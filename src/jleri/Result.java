package jleri;

public class Result {
    public final boolean isValid;
    public final int pos;
    public final Node tree;

    private Expecting expect;

    Result(boolean isValid, int pos, Node tree, Expecting expect) {
        this.isValid = isValid;
        this.pos = pos;
        this.tree = tree;
        this.expect = expect;
    }

    Element[] getExpecting() {
        return this.expect.getExpection();
    }
};
