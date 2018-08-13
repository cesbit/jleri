package technology.transceptor.jleri;

import java.util.ArrayList;


class Node {
    final Element elem;
    final int start;
    int end;
    ArrayList<Node> children;
    public Object data;  // Public, free to use for anything you like

    Node(Element elem, int start) {
        this.elem = elem;
        this.start = start;
        this.end = start;
        this.children = new ArrayList<Node>();
        this.data = null;  // Public, free to use for anything you like
    }
}