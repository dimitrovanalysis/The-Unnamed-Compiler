cd ..
java org.antlr.v4.Tool UnnamedLexer.g4 -no-listener -visitor -o ./src/unnamed/frontend/parser -package unnamed.frontend.parser
java org.antlr.v4.Tool UnnamedParser.g4 -no-listener -visitor -o ./src/unnamed/frontend/parser -package unnamed.frontend.parser
