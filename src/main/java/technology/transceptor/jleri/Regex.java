package technology.transceptor.jleri;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex extends Element {
    private final Pattern pattern;

    public Regex(Enum<?> id, Pattern pattern) {
        super(id);
        this.pattern = pattern;
    }

    public Regex(Enum<?> id, String s) {
        this(id, Pattern.compile(s));
    }

    public Regex(Pattern pattern) {
        this(null, pattern);
    }

    public Regex(String s) {
        this(null, Pattern.compile(s));
    }

    @Override
    Node parse(Parser p, Node parent, Rule r) throws MaxRecursionException {
        Matcher matcher = this.pattern.matcher(p.s.substring(parent.end));
        if (matcher.find() && matcher.start() == 0) {
            Node nd = new Node(this, parent.end);
            nd.end = parent.end + matcher.end();
            p.appendChild(parent, nd);
            return nd;
        }
        p.expect.update(this, parent.end);
        return null;
    }

    @Override
    public String toString() {
        return String.format(
            "<Regex id:%d pattern:%s>",
            this.getId(),
            this.pattern.pattern());
    }

    /**
     * @return the pattern
     */
    public Pattern getPattern() {
        return pattern;
    }
}