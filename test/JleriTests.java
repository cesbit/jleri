import jleri.Sequence;
import jleri.Keyword;
import jleri.Grammar;
import jleri.Result;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class JleriTests {

    @Test
    public void testKeyword() {
        Keyword hi = new Keyword("hi");
        Grammar grammar = new Grammar(hi);

        // assert statements
        assertEquals(null, hi.getId());
        assertEquals(false, hi.isIgnCase());
        assertEquals(true, grammar.parse("hi").isValid);
        assertEquals(false, grammar.parse("Hi").isValid);
        assertEquals(false, grammar.parse("hello").isValid);
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
    }
}