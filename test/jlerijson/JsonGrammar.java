package jlerijson;

/**
 * This grammar is generated using the Grammar.export_java() method and
 * should be used with the goleri module.
 *
 * Source class: JsonGrammar
 * Created at: 2018-07-04 11:04:11
 */

import jleri.Grammar;
import jleri.Element;
import jleri.Regex;
import jleri.Ref;
import jleri.Sequence;
import jleri.List;
import jleri.Token;
import jleri.Keyword;
import jleri.Choice;

public class JsonGrammar extends Grammar {
    enum Ids {
        JSON_ARRAY,
        JSON_MAP,
        JSON_MAP_ITEM,
        K_FALSE,
        K_NULL,
        K_TRUE,
        R_FLOAT,
        R_INTEGER,
        R_STRING,
        START
    }

    private static final Element START = new Ref();
    private static final Element R_STRING = new Regex(Ids.R_STRING, "^(\")(?:(?=(\\\\?))\\2.)*?\\1");
    private static final Element R_FLOAT = new Regex(Ids.R_FLOAT, "^-?[0-9]+\\.?[0-9]+");
    private static final Element R_INTEGER = new Regex(Ids.R_INTEGER, "^-?[0-9]+");
    private static final Element K_TRUE = new Keyword(Ids.K_TRUE, "true", false);
    private static final Element K_FALSE = new Keyword(Ids.K_FALSE, "false", false);
    private static final Element K_NULL = new Keyword(Ids.K_NULL, "null", false);
    private static final Element JSON_MAP_ITEM = new Sequence(
        Ids.JSON_MAP_ITEM,
        R_STRING,
        new Token(":"),
        START
    );
    private static final Element JSON_MAP = new Sequence(
        Ids.JSON_MAP,
        new Token("{"),
        new List(JSON_MAP_ITEM, new Token(","), 0, null, false),
        new Token("}")
    );
    private static final Element JSON_ARRAY = new Sequence(
        Ids.JSON_ARRAY,
        new Token("["),
        new List(START, new Token(","), 0, null, false),
        new Token("]")
    );

    public JsonGrammar() {
        super(START, "^\\w+");
        ((Ref) START).set(new Choice(
            Ids.START,
            true,
            R_STRING,
            R_FLOAT,
            R_INTEGER,
            K_TRUE,
            K_FALSE,
            K_NULL,
            JSON_MAP,
            JSON_ARRAY
        ));
    }
}