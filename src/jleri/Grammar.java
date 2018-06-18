package jleri;

import java.util.regex.Pattern;

public class Grammar {
    Element elem;
    Pattern reKeywords;

    public Grammar(Element elem, Pattern reKeywords) {
        this.elem = elem;
        this.reKeywords = reKeywords;
    }
}