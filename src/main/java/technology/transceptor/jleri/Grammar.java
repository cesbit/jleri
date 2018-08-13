package technology.transceptor.jleri;

import java.util.regex.Pattern;
import java.lang.Character;

public class Grammar {
    Element elem;
    Pattern reKeywords;

    public Grammar(Element elem, Pattern reKeywords) {
        this.elem = elem;
        this.reKeywords = reKeywords;
    }

    public Grammar(Element elem, String reKeywords) {
        this(elem, Pattern.compile(reKeywords));
    }

    public Grammar(Element elem) {
        this(elem, Pattern.compile("^\\w+"));
    }

    /**
     * Parse a string to the grammar
     *
     * @param s is the string to parse
     * @return a Result Object which contains a Node Tree and an isValid
     *  property which can be checked if the parse was valid according the
     *  grammar and more.
     */
    public Result parse(String s) throws MaxRecursionException {
        Parser p = new Parser(s, this.reKeywords);
        Node nd = new Node(null, 0);
        Node n = p.walk(nd, this.elem, Mode.REQUIRED, null);
        boolean isValid = n != null;
        int end = s.length();

        while (end > 0 && Character.isWhitespace(s.charAt(end - 1))) {
            end--;
        }

        if (nd.end < end) {
            isValid = false;
        }

        int pos = isValid ? s.length() : p.expect.pos;

        if (nd.end < end && !p.expect.hasRequired()) {
            p.expect.setMode(nd.end, Mode.REQUIRED);
            p.expect.update(Eos.EOS, nd.end);
        }

        Result result = new Result(isValid, pos, nd, p.expect);
        return result;
    }
}