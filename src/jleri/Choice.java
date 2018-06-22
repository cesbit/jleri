package jleri;

import java.util.Arrays;

public class Choice extends Element {
    private final boolean mostGreedy;
    private final Element elems[];

    public Choice(Integer id, boolean mostGreedy, Element... elems) {
        super(id);
        assert elems.length > 0;
        this.elems = elems;
        this.mostGreedy = mostGreedy;
    }

    public Choice(boolean mostGreedy, Element... elems) {
        this(null, mostGreedy, elems);
    }

    public Choice(Integer id, Element... elems) {
        this(id, true, elems);
    }

    public Choice(Element... elems) {
        this(null, true, elems);
    }

    @Override
    Node parse(Parser p, Node parent) {
        return this.mostGreedy
            ? this.parseMostGreedy(p, parent)
            : this.parseFirst(p, parent);
    }

    @Override
    public String toString() {
        return String.format(
            "<Choice id:%d greedy:%b elems:%s>",
            this.getId(),
            this.mostGreedy,
            Arrays.toString(this.elems));
    }

    private Node parseMostGreedy(Parser p, Node parent) {
        Node mgNode = null;

        for (Element elem : this.elems) {
            Node nd = new Node(this, parent.end);
            Node n = p.walk(nd, elem, Mode.REQUIRED);
            if (n != null && (mgNode == null || nd.end > mgNode.end)) {
                mgNode = nd;
            }
        }

        if (mgNode != null) {
            p.appendChild(parent, mgNode);
        }

        return mgNode;
    }

    private Node parseFirst(Parser p, Node parent) {
        for (Element elem : this.elems) {
            Node nd = new Node(this, parent.end);
            Node n = p.walk(nd, elem, Mode.REQUIRED);
            if (n != null) {
                p.appendChild(parent, nd);
                return nd;
            }
        }

        return null;
    }

    /**
     * @return the mostGreedy
     */
    public boolean isMostGreedy() {
        return mostGreedy;
    }
}
