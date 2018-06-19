package jleri;


class _Eos extends Element {
    _Eos() {
        super(0);
    }

    @Override
    Node parse(Parser p, Node parent) {
        return null;
    }
};


public class Eos {
    public static final _Eos EOS = new _Eos();
}
