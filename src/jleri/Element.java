
package jleri;

abstract class Element {
    final int gid;

    Element(int gid) {
        this.gid = gid;
    }

    abstract Node parse(Parser p, Node parent);
}