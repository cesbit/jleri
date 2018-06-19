package jleri;

public class Sequence extends Element {
    private final Element[] elems;

    public Sequence(Integer id, Element... elems) {
        super(id);
        assert elems.length > 0;
        this.elems = elems;
    }

    public Sequence(Element... elems) {
        this(null, elems);
    }

    @Override
    Node parse(Parser p, Node parent) {
        Node nd = new Node(this, parent.end);
        for (Element elem : this.elems) {
            Node n = p.walk(nd, elem, Mode.REQUIRED);
            if (n == null) {
                return null;
            }
        }
        p.appendChild(parent, nd);
        return nd;
    }
}