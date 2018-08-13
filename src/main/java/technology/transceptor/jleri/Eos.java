package technology.transceptor.jleri;


public class Eos extends Element {

    public static final Eos EOS = new Eos();

    private Eos() {
        super(null);
    }

    @Override
    Node parse(Parser p, Node parent, Rule r) throws MaxRecursionException {
        return null;
    }

    @Override
    public String toString() {
        return "<EndOfStatement>";
    }
};



