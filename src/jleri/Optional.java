package jleri;

public class Optional extends Element {
    private final Element elem;

    public Optional(Integer id, Element elem) {
        super(id);
        this.elem = elem;
    }

    public Optional(Element elem) {
        this(null, elem);
    }

    @Override
    Node parse(Parser p, Node parent, Rule r) throws MaxRecursionException {
        Node nd = new Node(this, parent.end);
        Node n = p.walk(nd, this.elem, Mode.OPTIONAL, r);
        if (n != null) {
            p.appendChild(parent, nd);
        }
        return nd;
    }

    @Override
    public String toString() {
        return String.format(
            "<Optional id:%d elem:%s>", this.getId(), this.elem.toString());
    }
}
