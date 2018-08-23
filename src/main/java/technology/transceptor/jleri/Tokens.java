package technology.transceptor.jleri;

public class Tokens extends Element {
    private final Token[] tokens;

    public Tokens(Enum<?> id, String tokens) {
        super(id);
        String[] tStrings = tokens.split("\\s+");
        this.tokens = new Token[tStrings.length];
        for(int i = 0; i < tStrings.length; i++) {
            this.tokens[i] = new Token(tStrings[i]);
        }
    }

    public Tokens(String tokens) {
        this(null, tokens);
    }

    @Override
    Node parse(Parser p, Node parent, Rule r) throws MaxRecursionException {
        for(Token t: tokens) {
            if (t.match(p.s, parent.end)) {
                Node nd = new Node(this, parent.end);
                nd.end = parent.end + t.length();
                p.appendChild(parent, nd);
                return nd;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return String.format(
            "<Tokens id:%d tokens:[%s]>", this.getId(), this.asString());
    }

    public String asString() {
        String[] tmp = new String[tokens.length];
        for(int i = 0; i < tokens.length; i++) {
            tmp[i] = tokens[i].getToken();
        }
        return String.join(" ", tmp);
    }

    public Token[] getTokens() {
        return tokens;
    }
}