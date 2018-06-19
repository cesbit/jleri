package jleri;

import java.util.Arrays;

public class Choice extends Element {
    boolean mostGreedy;
    Element elems[];

    Choice(int id, Element[] elems, boolean mostGreedy) {
        super(id);
        assert elems.length > 0;
        this.elems = elems;
        this.mostGreedy = mostGreedy;
    }

    Choice(Element[] elems) {
        this(0, true, elems);
    }

    Choice(Boolean mostGreedy, Element[] elems) {
        this(0, mostGreedy, elems);
    }

    Choice(int id, Element[] elems) {
        this(id, true, elems);
    }

    @Override
    Node parse(Parser p, Node parent) {
        return null;
    }
}
