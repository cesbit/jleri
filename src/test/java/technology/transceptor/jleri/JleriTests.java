import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.util.Arrays;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import jleri.Choice;
import jleri.Element;
import jleri.Eos;
import jleri.Grammar;
import jleri.Keyword;
import jleri.List;
import jleri.Optional;
import jleri.Prio;
import jleri.MaxRecursionException;
import jleri.Ref;
import jleri.Regex;
import jleri.Repeat;
import jleri.Result;
import jleri.Sequence;
import jleri.This;
import jleri.Token;
import jleri.Tokens;
import jlerijson.JsonGrammar;
import jlerisiri.SiriGrammar;

enum TestIds {ID};

public class JleriTests {

    @Test
    public void testKeyword() throws MaxRecursionException {
        Keyword hi = new Keyword("hi");
        Grammar grammar = new Grammar(hi);

        // assert statements
        assertEquals(null, hi.getId());
        assertEquals(false, hi.isIgnCase());
        assertEquals(true, grammar.parse("hi").isValid);
        assertEquals(true, grammar.parse(" hi ").isValid);
        assertEquals(false, grammar.parse("Hi").isValid);
        assertEquals(false, grammar.parse("hello").isValid);
        assertEquals(
            new HashSet<Element>() {{ }},
            grammar.parse("hi").getExpecting());
        assertEquals(
            new HashSet<Element>() {{
                add(hi);
            }},
            grammar.parse("").getExpecting());
    }

    @Test
    public void testKeywordIgnCase() throws MaxRecursionException {

        Keyword hi = new Keyword(TestIds.ID, "hi", true);
        Grammar grammar = new Grammar(hi);

        // assert statements
        assertEquals(TestIds.ID, hi.getId());
        assertEquals(true, hi.isIgnCase());
        assertEquals(true, grammar.parse("hi").isValid);
        assertEquals(true, grammar.parse("Hi").isValid);
        assertEquals(false, grammar.parse("hello").isValid);
        assertEquals(String.format("<Keyword id:%s keyword:hi>", TestIds.ID.name()), hi.toString());
        assertEquals(
            new HashSet<Element>() {{
                add(hi);
            }},
            grammar.parse("").getExpecting());
    }

    @Test
    public void testSequence() throws MaxRecursionException {
        Keyword hi = new Keyword("hi");
        Keyword iris = new Keyword("iris");
        Sequence seq = new Sequence(hi, iris);
        Grammar grammar = new Grammar(seq);

        // assert statements
        assertEquals(true, grammar.parse("hi iris").isValid);
        assertEquals(false, grammar.parse("hi sasha").isValid);
        assertEquals(
            String.format(
                "<Sequence id:null elems:[%s, %s]>",
                hi.toString(),
                iris.toString()),
            seq.toString());
    }

    @Test
    public void testChoiceMostGreedy() throws MaxRecursionException {
        Keyword hi = new Keyword("hi");
        Keyword iris = new Keyword("iris");
        Sequence seq = new Sequence(hi, iris);
        Choice choice = new Choice(hi, seq);
        Grammar grammar = new Grammar(choice);

        // assert statements
        assertEquals(true, grammar.parse("hi").isValid);
        assertEquals(true, grammar.parse("hi iris").isValid);
        assertEquals(false, grammar.parse("hi sasha").isValid);
        assertEquals(
            String.format(
                "<Choice id:null greedy:true elems:[%s, %s]>",
                hi.toString(),
                seq.toString()),
            choice.toString());
    }

    @Test
    public void testChoiceFirstMatch() throws MaxRecursionException {
        Keyword hi = new Keyword("hi");
        Keyword iris = new Keyword("iris");
        Sequence seq = new Sequence(hi, iris);
        Choice choice = new Choice(false, hi, seq);
        Grammar grammar = new Grammar(choice);

        // assert statements
        assertEquals(true, grammar.parse("hi").isValid);
        assertEquals(false, grammar.parse("hi iris").isValid);
        assertEquals(false, grammar.parse("hi sasha").isValid);
        assertEquals(
            String.format(
                "<Choice id:null greedy:false elems:[%s, %s]>",
                hi.toString(),
                seq.toString()),
            choice.toString());
    }

    @Test
    public void testOptional() throws MaxRecursionException {
        Keyword hi = new Keyword("hi");
        Optional optional = new Optional(hi);
        Grammar grammar = new Grammar(optional);

        // assert statements
        assertEquals(true, grammar.parse("hi").isValid);
        assertEquals(true, grammar.parse("").isValid);
        assertEquals(false, grammar.parse("hello").isValid);
        assertEquals(0, grammar.parse("").pos);
        assertEquals(
            new HashSet<Element>() {{
                add(hi);
                add(Eos.EOS);
            }},
            grammar.parse("x").getExpecting());
        assertEquals(
            String.format(
                "<Optional id:null elem:%s>",
                hi.toString()),
                optional.toString());
    }

    @Test
    public void testToken() throws MaxRecursionException {
        Token dot = new Token(".");
        Grammar grammar = new Grammar(dot);

        // assert statements
        assertEquals(true, grammar.parse(".").isValid);
        assertEquals(false, grammar.parse("..").isValid);
        assertEquals(false, grammar.parse("").isValid);
        assertEquals("<Token id:null token:.>", dot.toString());
    }

    @Test
    public void testTokenMultiChars() throws MaxRecursionException {
        Token not = new Token("!=");
        Grammar grammar = new Grammar(not);

        // assert statements
        assertEquals(true, grammar.parse(" != ").isValid);
        assertEquals(false, grammar.parse("!").isValid);
        assertEquals("<Token id:null token:!=>", not.toString());
    }

    @Test
    public void testList() throws MaxRecursionException {
        Keyword hi = new Keyword("hi");
        List list = new List(hi);
        Grammar grammar = new Grammar(list);

        // assert statements
        assertEquals(0, list.getMin());
        assertEquals(null, list.getMax());
        assertEquals(false, list.isOptClose());
        assertEquals(true, grammar.parse("hi, hi, hi").isValid);
        assertEquals(true, grammar.parse("hi").isValid);
        assertEquals(true, grammar.parse("").isValid);
        assertEquals(false, grammar.parse("hi,").isValid);
    }

    @Test
    public void testListAltOptions() throws MaxRecursionException {
        Keyword hi = new Keyword("hi");
        List list = new List(hi, new Token('-'), 1, 3, true);
        Grammar grammar = new Grammar(list);

        // assert statements
        assertEquals(1, list.getMin());
        assertEquals(Integer.valueOf(3), list.getMax());
        assertEquals(true, list.isOptClose());
        assertEquals(true, grammar.parse("hi - hi - hi").isValid);
        assertEquals(true, grammar.parse("hi-hi-hi-").isValid);
        assertEquals(true, grammar.parse("hi").isValid);
        assertEquals(false, grammar.parse("").isValid);
        assertEquals(false, grammar.parse("-").isValid);
        assertEquals(false, grammar.parse("hi-hi-hi-hi").isValid);
    }

    @Test
    public void testRepeat() throws MaxRecursionException {
        Keyword hi = new Keyword("hi");
        Repeat repeat = new Repeat(hi);
        Grammar grammar = new Grammar(repeat);

        // assert statements
        assertEquals(0, repeat.getMin());
        assertEquals(null, repeat.getMax());
        assertEquals(true, grammar.parse("hi hi hi").isValid);
        assertEquals(true, grammar.parse("hi").isValid);
        assertEquals(true, grammar.parse("").isValid);
        assertEquals(false, grammar.parse("hihi").isValid);
        assertEquals(false, grammar.parse("ha").isValid);
    }

    @Test
    public void testRepeatAltOptions() throws MaxRecursionException {
        Keyword hi = new Keyword("hi");
        Repeat repeat = new Repeat(hi, 1, 3);
        Grammar grammar = new Grammar(repeat);

        // assert statements
        assertEquals(1, repeat.getMin());
        assertEquals(Integer.valueOf(3), repeat.getMax());
        assertEquals(true, grammar.parse("hi  hi  hi").isValid);
        assertEquals(true, grammar.parse("hi").isValid);
        assertEquals(false, grammar.parse("").isValid);
        assertEquals(false, grammar.parse("hi hi hi hi").isValid);
    }

    @Test
    public void testTokens() throws MaxRecursionException {
        Tokens tokens = new Tokens("== != >= <=   >   < ");
        Grammar grammar = new Grammar(tokens);
        String shouldBe = "== != >= <= > <";

        // assert statements
        assertEquals(shouldBe, tokens.asString());
        assertEquals(true, grammar.parse("==").isValid);
        assertEquals(true, grammar.parse("<=").isValid);
        assertEquals(true, grammar.parse(">").isValid);
        assertEquals(false, grammar.parse("").isValid);
        assertEquals(false, grammar.parse("=").isValid);
        assertEquals(
            "<Tokens id:null tokens:[" + shouldBe + "]>", tokens.toString());
    }

    @Test
    public void testRegex() throws MaxRecursionException {
        String pattern = "(/[^/\\\\]*(?:\\\\.[^/\\\\]*)*/i?)";
        Regex regex = new Regex(pattern);
        Grammar grammar = new Grammar(regex);

        // assert statements
        assertEquals(true, grammar.parse("/hi/").isValid);
        assertEquals(true, grammar.parse("/hi/i").isValid);
        assertEquals(true, grammar.parse("  //i ").isValid);
        assertEquals(false, grammar.parse("x//i ").isValid);
        assertEquals(false, grammar.parse("//x").isValid);
        assertEquals(false, grammar.parse("").isValid);
        assertEquals(false, grammar.parse("/").isValid);
        assertEquals(false, grammar.parse("///").isValid);
        assertEquals(pattern, regex.getPattern().pattern());
        assertEquals(
            String.format("<Regex id:null pattern:%s>", pattern),
            regex.toString());
    }

    @Test
    public void testRef() throws MaxRecursionException {
        Ref ref = new Ref();
        Keyword hi = new Keyword("hi");
        Grammar grammar = new Grammar(ref);
        ref.set(hi);

        // assert statements
        assertEquals(true, grammar.parse("hi").isValid);
        assertEquals(false, grammar.parse("").isValid);
        assertEquals(String.format("<Ref elem:%s>", hi), ref.toString());
    }

    @Test
    public void testPrio() throws MaxRecursionException {
        Prio prio = new Prio(
            new Keyword("hi"),
            new Keyword("bye"),
            new Sequence(new Token('('), This.THIS, new Token(')')),
            new Sequence(This.THIS, new Keyword("or"), This.THIS),
            new Sequence(This.THIS, new Keyword("and"), This.THIS)
        );

        Grammar grammar = new Grammar(prio);

        // assert statements
        assertEquals(true, grammar.parse("hi").isValid);
        assertEquals(true, grammar.parse("(bye)").isValid);
        assertEquals(true, grammar.parse("(hi and bye)").isValid);
        assertEquals(true, grammar.parse("(hi or hi) and (hi or hi)").isValid);
        assertEquals(true, grammar.parse("(hi or (hi and bye))").isValid);
        assertEquals(false, grammar.parse("").isValid);
        assertEquals(false, grammar.parse("(hi").isValid);
        assertEquals(false, grammar.parse("()").isValid);
        assertEquals(false, grammar.parse("(hi or hi) and").isValid);
        try {
            grammar.parse(
                "(((((((((((((((((((((((((((((((((((((((((((((((((((hi" +
                ")))))))))))))))))))))))))))))))))))))))))))))))))))");
            assertEquals(false, true);  // the above statement should fail
        } catch (MaxRecursionException ex) {
            assertEquals("Max recursion depth reached", ex.getMessage());
        }
    }

    @Test
    public void testJsonGrammar() throws MaxRecursionException {
        JsonGrammar grammar = new JsonGrammar();

        // assert statements
        assertEquals(true, grammar.parse(
            "{\"valid\": [1, 2, 3, true, false, null]}").isValid);
    }

    @Test
    public void testSiriGrammar() throws MaxRecursionException {
        SiriGrammar grammar = new SiriGrammar();

        // assert statements
        assertEquals(true, grammar.parse(
            "select mean(1h * 5) from /someexpr.*/").isValid);
        assertEquals(true, grammar.parse(
            "list series name, length").isValid);
        assertEquals(true, grammar.parse(
            "list series where type == string and length > 5").isValid);
        assertEquals(false, grammar.parse(
            "list series name, length, ").isValid);
    }
}