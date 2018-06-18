package jleri;

public class Keyword extends Element {
    String keyword;
    boolean ignCase;

    public Keyword(int gid, String keyword, boolean ignCase) {
        super(gid);
        this.keyword = keyword;
        this.ignCase = ignCase;
    }


}