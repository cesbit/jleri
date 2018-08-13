package jleri;

import java.util.Arrays;

class Wrapped extends Element {
    private static int MAX_RECURSION_DEPTH = 50;
    private final Element[] elems;

    Wrapped(Element... elems) {
        super(null);
        this.elems = elems;
    }

    Node parse(Parser p, Node parent, Rule r) throws MaxRecursionException {
        if (r.depth++ > MAX_RECURSION_DEPTH) {
            throw new MaxRecursionException();
        }

        for (Element elem: this.elems) {
            Node nd = new Node(this, parent.end);
            Node n = p.walk(nd, elem, Mode.REQUIRED, r);
            if (n != null) {
                r.update(n);
            }
        }

        Node nd = r.tested.get(parent.end);
        if (nd != null) {
            p.appendChild(parent, nd);
        }

        return nd;
    }

    public String toString() {
        return String.format("<PrioW elems:%s>", Arrays.toString(this.elems));
    }
}