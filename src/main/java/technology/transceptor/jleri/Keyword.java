package technology.transceptor.jleri;

public class Keyword extends Element {
    private final String keyword;
    private final boolean ignCase;

    public Keyword(Enum id, String keyword, boolean ignCase) {
        super(id);
        this.keyword = keyword;
        this.ignCase = ignCase;
    }

    public Keyword(String keyword, boolean ignCase) {
        this(null, keyword, ignCase);
    }

    public Keyword(Enum id, String keyword) {
        this(id, keyword, false);
    }

    public Keyword(String keyword) {
        this(null, keyword, false);
    }

    /**
     * @return the ignCase
     */
    public boolean isIgnCase() {
        return ignCase;
    }

    @Override
    public String toString() {
        Enum id = this.getId();
        return String.format(
            "<Keyword id:%s keyword:%s>", id == null ? id : id.name(), this.keyword);
    }

    @Override
    Node parse(Parser p, Node parent, Rule r) throws MaxRecursionException {
        String s = p.getKeyword(parent.end);

        boolean match = s != null && (this.ignCase
            ? s.equalsIgnoreCase(this.keyword)
            : s.equals(this.keyword));

            Node nd = null;

        if (match) {
            nd = new Node(this, parent.end);
            nd.end = parent.end + this.keyword.length();
            p.appendChild(parent, nd);
        } else {
            p.expect.update(this, parent.end);
        }

        return nd;
    }
}