package technology.transceptor.jleri;

public class Repeat extends Element {
    private final Element elem;
    private final int min;
    private final Integer max;

    public Repeat(Enum<?> id, Element elem, int min, Integer max) {
        super(id);
        assert min >= 0;
        assert max == null || max >= min;
        this.elem = elem;
        this.min = min;
        this.max = max;
    }

    public Repeat(Element elem, int min, Integer max) {
        this(null, elem, min, max);
    }

    public Repeat(Enum<?> id, Element elem) {
        this(id, elem, 0, null);
    }

    public Repeat(Element elem) {
        this(null, elem, 0, null);
    }

    @Override
    Node parse(Parser p, Node parent, Rule r) throws MaxRecursionException {
        Node nd = new Node(this, parent.end);
        int i;
        for (i = 0; this.max == null || i < this.max; i++) {
            if (p.walk(nd, this.elem, Mode.REQUIRED, r) == null)
                break;
        }

        if (i < this.min) {
            return null;
        }

        p.appendChild(parent, nd);
        return nd;
    }

    @Override
    public String toString() {
        return String.format(
            "<Repeat id:%d elem:%s min:%d max:%d>",
            this.getId(),
            this.elem,
            this.min,
            this.max);
    }

    public int getMin() {
        return min;
    }

    public Integer getMax() {
        return max;
    }
}