package technology.transceptor.jleri;

public class Ref extends Element {
    private Element elem;

    public Ref() {
        super(null);
        this.elem = null;
    }

    public Element set(Element elem) {
        this.elem = elem;
        return this.elem;
    }

    public boolean isSet() {
        return this.elem != null;
    }

    @Override
    Node parse(Parser p, Node parent, Rule r) throws MaxRecursionException {
        return elem.parse(p, parent, r);
    }

    @Override
    public String toString() {
        return String.format("<Ref isSet:%b>", this.isSet());
    }
}