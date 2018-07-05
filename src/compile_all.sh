javac -d ../classes \
    jleri/Choice.java \
    jleri/Grammar.java \
    jleri/Keyword.java \
    jleri/List.java \
    jleri/MaxRecursionException.java \
    jleri/Optional.java \
    jleri/Parser.java \
    jleri/Prio.java \
    jleri/Ref.java \
    jleri/Regex.java \
    jleri/Repeat.java \
    jleri/Result.java \
    jleri/Rule.java \
    jleri/Sequence.java \
    jleri/This.java \
    jleri/Token.java \
    jleri/Tokens.java \

jar cvf ../jleri.jar -C ../classes .
