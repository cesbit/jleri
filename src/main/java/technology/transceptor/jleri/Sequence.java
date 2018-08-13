package technology.transceptor.jleri;

import java.util.Arrays;

public class Sequence extends Element {
    private final Element[] elems;

    public Sequence(Enum id, Element... elems) {
        super(id);
        assert elems.length > 0;
        this.elems = elems;
    }

    public Sequence(Element... elems) {
        this(null, elems);
    }

    @Override
    Node parse(Parser p, Node parent, Rule r) throws MaxRecursionException {
        Node nd = new Node(this, parent.end);
        for (Element elem : this.elems) {
            Node n = p.walk(nd, elem, Mode.REQUIRED, r);
            if (n == null) {
                return null;
            }
        }
        p.appendChild(parent, nd);
        return nd;
    }

    @Override
    public String toString() {
        return String.format(
            "<Sequence id:%d elems:%s>",
            this.getId(),
            Arrays.toString(this.elems));
    }
}