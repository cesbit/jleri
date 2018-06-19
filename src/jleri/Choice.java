package jleri;

import java.util.Arrays;

public class Choice extends Element {
    boolean mostGreedy;
    Element elems[];

    Choice(int gid, boolean mostGreedy, Element[] elems) {
        super(gid);
        this.mostGreedy = mostGreedy;
        assert elems.length > 0;
        this.elems = elems;
    }

    Choice(Element[] elems) {
        this(0, true, elems);
    }

    Choice(Boolean mostGreedy, Element[] elems) {
        this(0, mostGreedy, elems);
    }

    Choice(int gid, Element[] elems) {
        this(gid, true, elems);
    }

    @Override
    Node parse(Parser p, Node parent) {
        return null;
    }
}
