import jleri.Choice;
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
        Keyword hi = new Keyword(0, "hi", false);

        Grammar grammar = new Grammar(hi, Pattern.compile("^\\w+"));

        Result res = grammar.parse("hi");

        // assert statements
        assertEquals(true, res.isValid);
    }

    @Test
    public void testChoice() {
        Keyword hi = new Keyword(0, "hi", false);

        // assert statements
        assertEquals(0, 0);
    }
}