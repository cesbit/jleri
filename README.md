# JLeRi

A left-right parser for the Java language.

---------------------------------------
  * [Installation](#installation)
  * [Related projects](#related-projects)
  * [Quick usage](#quick-usage)
  * [Elements](#elements)
    * [Keyword](#keyword)
    * [Regex](#regex)
    * [Token](#token)
    * [Tokens](#tokens)
    * [Sequence](#sequence)
    * [Choice](#choice)
    * [Repeat](#repeat)
    * [List](#list)
    * [Optional](#optional)
    * [Ref](#ref)
    * [Prio](#prio)


---------------------------------------
## Installation
You can download the latest version [here](https://github.com/transceptor-technology/jleri/releases/latest). But you can also clone this repository and open the project in your favorite Java IDE. After building the project, grab the jleri.jar file and add it to your own project as library.

## Related projects
---------------------------------------
- [pyleri](https://github.com/transceptor-technology/pyleri): Python parser
- [jsleri](https://github.com/transceptor-technology/jsleri): JavaScript parser
- [libcleri](https://github.com/transceptor-technology/libcleri): C parser
- [goleri](https://github.com/transceptor-technology/goleri): Go parser

---------------------------------------
## Quick usage
We recommend using [pyleri](https://github.com/transceptor-technology/pyleri) for creating a grammar and export the grammar to jleri. This way you can create one single grammar and export the grammar to program languages like C, JavaScript, Go, Java and Python.

```java
// MyGrammar.java
import jleri.Grammar;
import jleri.Element;
import jleri.Sequence;
import jleri.Regex;
import jleri.Keyword;
import jleri.Result;
import jleri.MaxRecursionException;


public class MyGrammar extends Grammar {
    private static final Element R_NAME = new Regex("^(?:\"(?:[^\"]*)\")+");
    private static final Element K_HI = new Keyword("hi");
    private static final Element START = new Sequence(K_HI, R_NAME);

    public MyGrammar() {
        super(START);
    }

    public static void main(String []args) {
        MyGrammar grammar = new MyGrammar();

        try {
            Result res = grammar.parse("hi \"Iris\"");
            /**
             * res.isValid
             *      true or false depending if the string is successful parsed
             *      by the grammar or not.
             * res.tree
             *      contains the parse tree.
             * res.pos
             *      the position in the string where parsing has end.
             *      (if successful this will be equal to the string length)
             * res.getExpecting()
             *      returns a HashSet<Element> with elements which are expected at
             *      position res.pos. This can be used for auto-completion,
             *      auto correction or suggestions.
             */
            System.out.println(res.isValid);  // true
        } catch (MaxRecursionException ex) {
            // Maximum recursion occurred
        }
    }
}
```

Compile and run:
```
javac -cp jleri.jar MyGrammar.java && java -cp ./:jleri.jar MyGrammar
```

## Elements
Jleri has several elements which can be used to create a grammar. Each element is a subclass of `jleri.Keyword` and accepts an optional first `Enum id` which
can be used to identify the Element, for example in an node tree. The default id is set to `null` but as a user of jleri
you should never set the `id` to `null` yourself, just omit the `id` in that case.

### Keyword
```java
import jleri.Keyword;
//  Keyword(Enum id=null, String keyword, boolean ignCase=false)
```
The parser needs to match the keyword which is just a string. When matching keywords we need to tell the parser what characters are allowed in keywords. By default Jleri uses `^\w+` which is equal to `^[A-Za-z0-9_]+`. We can overwrite the default by using a second argument while calling `super` inside the grammar constructor.
Keyword() accepts a `boolean` argument `ignCase` which when omitted is set to `false` and tells the parser if we should match case insensitive.

Example:

```java
public class TicTacToe extends Grammar {
    private static final Element START = new Keyword("tic-tac-toe", true);

    public TicTacToe() {
        // Let's allow keywords with alphabetic characters and dashes.
        super(START, "^[A-Za-z-]+");
    }

    public static void main(String []args) {
        TicTacToe grammar = new TicTacToe();
        try {
            System.out.println(grammar.parse("Tic-Tac-Toe").isValid);  // true
        } catch (MaxRecursionException ex) {
            // Maximum recursion occurred
        }
    }
}
```

### Regex
```java
import jleri.Regex;
// Regex(Enum id=null, <java.util.regex.Pattern, String> pattern)
```
The parser uses a regular expression for matching this element.

See [Quick usage](#quick-usage) for an example on how to use `jleri.Regex`.

### Token
```java
import jleri.Token;
// Token(Enum id=null, <String, Char> token)
```
A token can be one or more characters and is usually used to match operators like `+`, `-`, `//` and so on.

Example:
```java
public class Ni extends Grammar {
    private static final Element K_NI = new Keyword("ni");
    private static final Element START = new Sequence(
        K_NI, new Token('+'), K_NI);

    public Ni() {
        super(START);
    }

    public static void main(String []args) {
        Ni grammar = new Ni();
        try {
            System.out.println(grammar.parse("ni+ni").isValid);  // true
        } catch (MaxRecursionException ex) {
            // Maximum recursion occurred
        }
    }
}
```

### Tokens
```java
import jleri.Tokens;
// Tokens(Enum id=null, String tokens)
```
Can be used to register multiple tokens at once. The `tokens` argument should be a string with tokens separated by spaces. If given tokens are different in size the parser will try to match the longest tokens first.

Example:
```java
public class Ni extends Grammar {
    private static final Element TKS = new Tokens("+ - !=");
    private static final Element START = new List(
        new Keyword("ni"), TKS, 0, null, false
    );

    public Ni() {
        super(START);
    }

    public static void main(String []args) {
        Ni grammar = new Ni();
        try {
            System.out.println(
                grammar.parse("ni + ni != ni- ni").isValid
            );  // true
        } catch (MaxRecursionException ex) {
            // Maximum recursion occurred
        }
    }
}
```

### Sequence
```java
import jleri.Sequence;
// Sequence(Enum id=null, Element... elems)
```
The parser needs to match each element in a sequence.

Example:
```java
public class TicTacToe extends Grammar {
    private static final Element START = new Sequence(
        new Keyword("Tic"),
        new Keyword("Tac"),
        new Keyword("Toe")
    );

    public TicTacToe() {
        super(START);
    }

    public static void main(String []args) {
        TicTacToe grammar = new TicTacToe();
        try {
            System.out.println(grammar.parse("Tic Tac Toe").isValid);  // true
        } catch (MaxRecursionException ex) {
            // Maximum recursion occurred
        }
    }
}
```

### Choice
```java
import jleri.Choice;
// Choice(Enum id=null, boolean mostGreedy=true, Element... elems)
```
The parser needs to choose between one of the given elements. Choice accepts a `boolean` argument `mostGreedy` which when omitted defaults to `true`. When `mostGreedy` is set to `false` the parser will stop at the first match. When `true` the parser will try each element and returns the longest match. Setting `mostGreedy` to `false` can provide some extra performance. Note that the parser will try to match each element in the exact same order they are parsed to Choice.

Example: let us use `Choice` to modify the Quick usage example to allow the string `bye "Iris"`
```java
public class MyGrammar extends Grammar {
    private static final Element R_NAME = new Regex("^(?:\"(?:[^\"]*)\")+");
    private static final Element K_HI = new Keyword("hi");
    private static final Element K_BYE = new Keyword("bye");
    private static final Element START = new Sequence(
        new Choice(K_HI, K_BYE),
        R_NAME
    );

    public MyGrammar() {
        super(START);
    }

    public static void main(String []args) {
        MyGrammar grammar = new MyGrammar();
        try {
            System.out.println(grammar.parse("hi \"Iris\"").isValid);  // true
            System.out.println(grammar.parse("bye \"Iris\"").isValid);  // true
        } catch (MaxRecursionException ex) {
            // Maximum recursion occurred
        }
    }
}
```

### Repeat
```java
import jleri.Repeat;
// Repeat(Enum id=null, Element elem, int min=0, Integer max=null)
```
The parser needs at least `min` elements and at most `max` elements. `min` can be any integer value equal or higher than 0. When `max` is set to `null` we allow unlimited number of elements or in case a value is used it must al least equal or higher than `min`.

Example:
```java
public class Ni extends Grammar {
    private static final Element START = new Repeat(new Keyword("ni"));

    public Ni() {
        super(START);
    }

    public static void main(String []args) {
        Ni grammar = new Ni();
        try {
            System.out.println(grammar.parse("ni ni ni ni").isValid);  // true
        } catch (MaxRecursionException ex) {
            // Maximum recursion occurred
        }
    }
}
```

It is not allowed to bind a name to the same element twice and `Repeat(elem, 1, 1)` is a common solution to bind the element a second (or more) time(s).

For example consider the following:
```java
public class MyGrammar extends Grammar {
    private static final Element R_NAME = new Regex("^(?:\"(?:[^\"]*)\")+");
    /**
     * We should avoid using this:
     * private static final Element R_ADDRESS = R_NAME
     *
     * Instead use Repeat:
     */
    private static final Element R_ADDRESS = new Repeat(R_NAME, 1, 1);
}
```

### List
```java
import jleri.List;
/**
 * List(Enum id=null,
 *      Element elem,
 *      Element delimiter=new Token(','),
 *      int min=0,
 *      Integer max=null,
 *      boolean optClose=false);
 */
```
List is like Repeat but with a delimiter. A comma (`Token`) is used as default delimiter but any element is allowed. `mix` and `max` work exactly like with Repeat. Argument `optClose` can be set to `true` to allow the list to end with a delimiter. When omitted this is set to `false` which means the list has to end with an element.

Example:
```java
public class Ni extends Grammar {
    private static final Element START = new List(new Keyword("ni"));

    public Ni() {
        super(START);
    }

    public static void main(String []args) {
        Ni grammar = new Ni();
        try {
            System.out.println(grammar.parse("ni, ni, ni").isValid);  // true
        } catch (MaxRecursionException ex) {
            // Maximum recursion occurred
        }
    }
}
```

### Optional
```java
import jleri.Optional;
// Optional(Enum id=null, Element elem)
```
The parser looks for an optional element. It is like using `Repeat(element, 0, 1)` but we encourage to use `Optional` since it is more readable. (and slightly faster)

Example:
```java
public class MyGrammar extends Grammar {
    private static final Element R_NAME = new Regex("^(?:\"(?:[^\"]*)\")+");
    private static final Element K_HI = new Keyword("hi");
    private static final Element START = new Sequence(
        K_HI,
        new Optional(R_NAME)
    );

    public MyGrammar() {
        super(START);
    }

    public static void main(String []args) {
        MyGrammar grammar = new MyGrammar();
        try {
            System.out.println(grammar.parse("hi \"Iris\"").isValid);  // true
            System.out.println(grammar.parse("hi").isValid);  // true
        } catch (MaxRecursionException ex) {
            // Maximum recursion occurred
        }
    }
}
```

### Ref
```java
import jleri.Ref;
// Ref()
```
The grammar can make a forward reference to make recursion possible. In the example below we create a forward reference to START but note that
a reference to any element can be made. `Ref()` accepts no arguments.

>Warning: A reference is not protected against testing the same position in
>in a string. This could potentially lead to an infinite loop.
>For example:
>```java
>Element r = new Ref();
>((Ref) r).set(new Optional(r));  // DON'T DO THIS
>```
>Use [Prio](#prio) if such recursive construction is required.

Example:
```java
public class NestedNi extends Grammar {
    private static final Element START = new Ref();
    private static final Element NI_ITM = new Choice(new Keyword('ni'), START);

    public NestedNi() {
        super(START);
        ((Ref) START).set(new Sequence(
            new Token('['), new List(NI_ITM), new Token(']')
        ));
    }

    public static void main(String []args) {
        NestedNi grammar = new NestedNi();
        try {
            System.out.println(grammar.parse(
                "[ni, ni, [ni, [], [ni, ni]]").isValid);  // true
        } catch (MaxRecursionException ex) {
            // Maximum recursion occurred
        }
    }
}
```

### Prio
```java
import jleri.Prio;
import jleri.This;  // exposes This.THIS
// Prio(Enum id, Element... elems)
```
Choose the first match from the `Prio` elements and allow `This.THIS` for recursive operations. With `This.THIS` we point to the `Prio` element.
Probably the example below explains how `Prio` and `This.THIS` can be used.

>Note: Use a [Ref](#ref) when possible.
>A `Prio` element is required when the same position in a string is potentially
>checked more than once.

Example:
```java
public class Ni extends Grammar {
    private static final Element K_NI = new Keyword("ni");
    private static final Element START = new Prio(
        K_NI,
        new Sequence(new Token('('), This.THIS, new Token(')')),
        new Sequence(This.THIS, new Keyword("or"), This.THIS),
        new Sequence(This.THIS, new Keyword("and"), This.THIS)
    );

    public Ni() {
        super(START);
    }

    public static void main(String []args) {
        Ni grammar = new Ni();
        try {
            System.out.println(
                grammar.parse("(ni or ni) and (ni or ni)").isValid
            );  // true
        } catch (MaxRecursionException ex) {
            // Maximum recursion occurred
        }
    }
}
```
