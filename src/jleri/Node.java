package jleri;

public class Node {
    public Element elem;
    public int start;
    public int end;
    public Object data;

    Node(Element elem, int start) {
        this.elem = elem;
        this.start = start;
        this.end = start;
        this.data = Void;
    }
}