package jleri;


public class This extends Element {

    public static final This THIS = new This();

    This() {
        super(null);
    }

    @Override
    Node parse(Parser p, Node parent, Rule r) throws MaxRecursionException {
        Node nd;

        if (!r.tested.containsKey(parent.end)) {
            nd = new Node(this, parent.end);
            r.tested.put(parent.end, null);
            Node n = p.walk(nd, r.root, Mode.REQUIRED, r);
            if (n == null) {
                return null;
            }
            r.tested.put(parent.end, n);
        } else {
            nd = r.tested.get(parent.end);
        }

        if (nd != null) {
            p.appendChild(parent, nd);
        }

        return nd;
    }

    @Override
    public String toString() {
        return "<This>";
    }
};
