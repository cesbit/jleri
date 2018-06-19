package jleri;

public class Keyword extends Element {
    String keyword;
    boolean ignCase;

    public Keyword(int gid, String keyword, boolean ignCase) {
        super(gid);
        this.keyword = keyword;
        this.ignCase = ignCase;
    }

    @Override
    Node parse(Parser p, Node parent) {
        String s = p.getKeyword(parent.end);
        boolean match = (this.ignCase)
            ? s.equals(this.keyword)
            : s.equalsIgnoreCase(this.keyword);
        Node nd = null;

        System.out.println("!!!!\n\n" + match);

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