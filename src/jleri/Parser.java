package jleri;

import java.util.HashMap;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.lang.Character;


class Parser {
    final String s;
    final Pattern reKeywords;
    final HashMap<Integer, String> kwc;
    final Expecting expect;

    Parser(String s, Pattern reKeywords) {
        this.s = s;
        this.reKeywords = reKeywords;
        this.expect = new Expecting();
        this.kwc = new HashMap<Integer, String>();
    }

    Node walk(Node parent, Element elem, Mode mode) {
        while (parent.end < this.s.length() &&
                Character.isWhitespace(this.s.charAt(parent.end))) {
            parent.end++;
        }
        	/* set expecting mode */
	    this.expect.setMode(parent.start, mode);

        return elem.parse(this, parent);
    }

    String getKeyword(int pos) {
        if (this.kwc.containsKey(pos)) {
            return this.kwc.get(pos);
        }
        Matcher matcher = this.reKeywords.matcher(this.s.substring(pos));
        String kw = matcher.find() ? matcher.group() : null;
        this.kwc.put(pos, kw);
        return kw;
    }

    void appendChild(Node parent, Node child) {
        if (child.end > this.expect.pos) {
            this.expect.empty();
        }
        parent.end = child.end;
        parent.children.add(child);
    }
}