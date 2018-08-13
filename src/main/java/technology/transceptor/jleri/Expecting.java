package technology.transceptor.jleri;

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

    /**
     * @return true if required has elements
     */
    boolean hasRequired() {
        return this.required.size() > 0;
    }

    /**
     * Clears both required and optional
     */
    void empty() {
        this.required.clear();
        this.optional.clear();
    }

    /**
     * Update expected according the current status
     *
     * @param elem will be added to either required or optional
     * @param pos is the position in the parse string where the element
     *  is expected
     */
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

    /**
     * Update the expect mode. The mode will not be changed if the mode at pos
     * is already set to OPTIONAL.
     *
     * @param pos is the position in the parse string where to change the mode
     * @param mode is the new mode.
     */
    void setMode(int pos, Mode mode) {
        if (this.modes.get(pos) == Mode.OPTIONAL) {
            return;
        }
        this.modes.put(pos, mode);
    }

    /**
     * @return the combined optional and required set of elements
     */
    public HashSet<Element> getExpection() {
        this.required.addAll(this.optional);
        this.optional.clear();
        return this.required;
    }
}
