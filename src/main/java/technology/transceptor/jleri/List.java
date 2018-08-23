package technology.transceptor.jleri;

public class List extends Element {
    private final Element elem;
    private final Element delimiter;
    private final int min;
    private final Integer max;
    private final boolean optClose;

    public List(Enum<?> id,
                Element elem,
                Element delimiter,
                int min,
                Integer max,
                boolean optClose) {
        super(id);
        assert min >= 0;
        assert max == null || max >= min;
        this.elem = elem;
        this.delimiter = delimiter;
        this.min = min;
        this.max = max;
        this.optClose = optClose;
    }

    public List(Element elem,
                Element delimiter,
                int min,
                Integer max,
                boolean optClose) {
        this(null, elem, delimiter, min, max, optClose);
    }

    public List(Enum<?> id, Element elem) {
        this(id, elem, new Token(','), 0, null, false);
    }

    public List(Element elem) {
        this(null, elem, new Token(','), 0, null, false);
    }

    @Override
    Node parse(Parser p, Node parent, Rule r) throws MaxRecursionException {
        Node nd = new Node(this, parent.end);
        Node n;
        int i = 0;
        int j = 0;
        while (true) {
            n = p.walk(nd, this.elem, getMode(i < this.min), r);
            if (n == null)
                break;
            i++;
            n = p.walk(nd, this.delimiter, getMode(i < this.min), r);
            if (n == null)
                break;
            j++;
        }

        if (    i < this.min ||
                (this.max != null && i > this.max) ||
                ((!this.optClose) && i != 0 && i == j)) {
            return null;
        }

        p.appendChild(parent, nd);
        return nd;
    }

    @Override
    public String toString() {
        return String.format(
            "<List id:%d elem:%s delimiter:%s min:%d max:%d optClose:%b>",
            this.getId(),
            this.elem,
            this.delimiter,
            this.min,
            this.max,
            this.optClose);
    }

    /**
     * @return the optClose
     */
    public boolean isOptClose() {
        return optClose;
    }

    /**
     * @return the min
     */
    public int getMin() {
        return min;
    }

    /**
     * @return the max
     */
    public Integer getMax() {
        return max;
    }

    /**
     * @return the delimiter
     */
    public Element getDelimiter() {
        return delimiter;
    }

    /**
     * @param required true if required and false if optional
     * @return Mode value based on required boolean
     */
    private Mode getMode(boolean required) {
        return required ? Mode.REQUIRED : Mode.OPTIONAL;
    }
}