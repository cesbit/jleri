package jleri;

public class MaxRecursionException extends Exception {
    private static final long serialVersionUID = 65745547234902956L;

    public MaxRecursionException() {
        super("Max recursion depth reached");
    }
}
