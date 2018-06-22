package jleri;

import java.util.HashSet;

public class Result {
    public final boolean isValid;
    public final int pos;
    public final Node tree;
    private final Expecting expect;

    Result(boolean isValid, int pos, Node tree, Expecting expect) {
        this.isValid = isValid;
        this.pos = pos;
        this.tree = tree;
        this.expect = expect;
    }

    public HashSet<Element> getExpecting() {
        return this.expect.getExpection();
    }
};
