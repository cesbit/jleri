package jleri;

import java.util.HashSet;
import java.util.HashMap;

enum Mode {
    REQUIRED,
    OPTIONAL
};

class Expecting {
    int pos;
    private HashSet<Element> required;
    private HashSet<Element> optional;
    private HashMap<Integer, Mode> modes;

    Expecting() {
        this.pos = 0;
        this.modes = new HashMap<Integer, Mode>();
        this.required = new HashSet<Element>();
        this.optional = new HashSet<Element>();
        this.modes.put(0, Mode.REQUIRED);
    }

    boolean hasRequired() {
        return this.required.size() > 0;
    }

    void empty() {
        this.required.clear();
        this.optional.clear();
    }

    void update(Element elem, int pos) {
        if (pos > this.pos) {
            this.empty();
            this.pos = pos;
        }
        if (pos == this.pos) {
            if (this.modes.get(pos) == Mode.REQUIRED) {
                this.required.add(elem);
            } else {
                this.optional.add(elem);
            }
        }
    }

    void setMode(int pos, Mode mode) {
        if (this.modes.get(pos) == Mode.OPTIONAL) {
            return;
        }
        this.modes.put(pos, mode);
    }

    public Element[] getExpection() {
        this.required.addAll(this.optional);
        this.optional.clear();
        return this.required.toArray(new Element[this.required.size()]);
    }
}
