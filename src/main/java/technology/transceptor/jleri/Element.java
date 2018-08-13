
package jleri;

public abstract class Element {
    private final Enum id;

    Element(Enum id) {
        this.id = id;
    }

    /**
     * @return the id of this element
     */
    public Enum getId() {
        return id;
    }

    /**
     * @param p is the parser object
     * @param parent Node to which this element will be added when successful
     * @return a new Node or null if the element has no match
     */
    abstract Node parse(Parser p, Node parent, Rule r)
        throws MaxRecursionException;

    /**
     * @return info about the element
     */
    public abstract String toString();
}