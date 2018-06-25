package jleri;

public class Ref extends Element {
    private Element elem;

    public Ref() {
        super(null);
        this.elem = null;
    }

    public void set(Element elem) {
        this.elem = elem;
    }

    @Override
    Node parse(Parser p, Node parent, Rule r) throws MaxRecursionException {
        return elem.parse(p, parent, r);
    }

    @Override
    public String toString() {
        return String.format("<Ref elem:%s>", this.elem);
    }
}