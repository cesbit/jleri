# JLeRi

A left-right parser for the Java language.

---------------------------------------
  * [Installation](#installation)
  * [Related projects](#related-projects)
  * [Quick usage](#quick-usage)

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
