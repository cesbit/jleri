package jleri;

import java.util.HashMap;

class Rule {
    HashMap<Integer, Node> tested;
    int depth;
    final Element root;

    Rule(Element root) {
        this.root = root;
        this.depth = 0;
        this.tested = new HashMap<Integer, Node>();
    }

    void update(Node nd) {
        if (tested.containsKey(nd.start)) {
            Node n = tested.get(nd.start);
            if (n != null && n.end >= nd.end) {
                return;
            }
        }
        this.tested.put(nd.start, nd);
    }
}