package technology.transceptor.jleri;

public class Prio extends Element {
    private final Element wrapped;

    public Prio(Enum<?> id, Element... elems) {
        super(id);
        this.wrapped = new Wrapped(elems);
    }

    public Prio(Element... elems) {
        this(null, elems);
    }

    @Override
    Node parse(Parser p, Node parent, Rule r) throws MaxRecursionException {
        Node nd = new Node(this, parent.end);
        Rule rule = new Rule(this.wrapped);
        Node n = p.walk(nd, rule.root, Mode.REQUIRED, rule);
        if (n == null) {
            return null;
        }
        p.appendChild(parent, nd);
        return nd;
    }

    @Override
    public String toString() {
        return String.format(
            "<Prio id:%d wrapped:%s>", this.getId(), this.wrapped);
    }
}