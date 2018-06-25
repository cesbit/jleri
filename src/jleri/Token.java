package jleri;

import java.util.Arrays;

public class Token extends Element {
    private final char[] token;

    public Token(Integer id, String token) {
        super(id);
        this.token = token.toCharArray();
    }

    public Token(Integer id, char token) {
        super(id);
        this.token = new char[] {token};
    }

    public Token(String token) {
        this(null, token);
    }

    public Token(char token) {
        this(null, token);
    }

    @Override
    Node parse(Parser p, Node parent, Rule r) throws MaxRecursionException {
        if (!this.match(p.s, parent.end)) {
            p.expect.update(this, parent.end);
            return null;
        }
        Node nd = new Node(this, parent.end);
        nd.end = parent.end + this.token.length;
        p.appendChild(parent, nd);
        return nd;
    }

    @Override
    public String toString() {
        return String.format(
            "<Token id:%d token:%s>", this.getId(), new String(token));
    }

    boolean match(String s, int i) {
        int n = s.length();
        for(char c: this.token) {
            if (i == n || c != s.charAt(i++) ) {
                return false;
            }
        }
        return true;
    }

    int length() {
        return token.length;
    }

    public String getToken() {
        return new String(token);
    }
}