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
import jleri.Repeat;
import jleri.Result;
import jleri.Sequence;
import jleri.Token;
import jleri.Tokens;


public class JleriTests {

    @Test
    public void testKeyword() {
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
    public void testKeywordIgnCase() {
        Integer id = 1;
        Keyword hi = new Keyword(id, "hi", true);
        Grammar grammar = new Grammar(hi);

        // assert statements
        assertEquals(id, hi.getId());
        assertEquals(true, hi.isIgnCase());
        assertEquals(true, grammar.parse("hi").isValid);
        assertEquals(true, grammar.parse("Hi").isValid);
        assertEquals(false, grammar.parse("hello").isValid);
        assertEquals(
            new HashSet<Element>() {{
                add(hi);
            }},
            grammar.parse("").getExpecting());
    }

    @Test
    public void testSequence() {
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
    public void testChoiceMostGreedy() {
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
    public void testChoiceFirstMatch() {
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
    public void testOptional() {
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
    public void testToken() {
        Token dot = new Token(".");
        Grammar grammar = new Grammar(dot);

        // assert statements
        assertEquals(true, grammar.parse(".").isValid);
        assertEquals(false, grammar.parse("..").isValid);
        assertEquals(false, grammar.parse("").isValid);
        assertEquals("<Token id:null token:.>", dot.toString());
    }

    @Test
    public void testTokenMultiChars() {
        Token not = new Token("!=");
        Grammar grammar = new Grammar(not);

        // assert statements
        assertEquals(true, grammar.parse(" != ").isValid);
        assertEquals(false, grammar.parse("!").isValid);
        assertEquals("<Token id:null token:!=>", not.toString());
    }

    @Test
    public void testList() {
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
    public void testListAltOptions() {
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
    public void testRepeat() {
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
    public void testRepeatAltOptions() {
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
    public void testTokens() {
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
}