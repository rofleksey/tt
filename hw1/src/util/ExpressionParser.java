package util;

import expression.Expression;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import parser.LambdaGrammarLexer;
import parser.LambdaGrammarParser;

import java.io.IOException;

public class ExpressionParser {
    public static Expression parse(String s) throws IOException {
        ANTLRInputStream is = new ANTLRInputStream(s);
        LambdaGrammarLexer lexer = new LambdaGrammarLexer(is);
        TokenStream ts = new CommonTokenStream(lexer);
        LambdaGrammarParser parser = new LambdaGrammarParser(ts);
        return parser.expression().expr;
    }
}