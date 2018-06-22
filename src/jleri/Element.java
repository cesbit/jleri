
package jleri;

public abstract class Element {
    private final Integer id;

    Element(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    abstract Node parse(Parser p, Node parent);
    public abstract String toString();
}