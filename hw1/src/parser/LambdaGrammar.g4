grammar LambdaGrammar;

@header {
import expression.*;
}

expression returns [Expression expr] : left=application SLASH var=variable DOT right=expression {$expr = new Application($left.expr, new Lambda($var.expr, $right.expr));}
                                     | SLASH var=variable DOT right=expression {$expr = new Lambda($var.expr, $right.expr);}
                                     | app=application {$expr = $app.expr;};

application returns [Expression expr] : left=application right=atom {$expr = new Application($left.expr, $right.expr);}
                                      | atom1=atom {$expr = $atom1.expr;};

atom returns [Expression expr] : LB e=expression RB {$expr = $e.expr;}
                               | var=variable {$expr = $var.expr;};

variable returns [Expression expr] : VAR {$expr = new Variable($VAR.text);};

fragment SPACE : '\t' | ' ' | '\r' | '\n'| '\u000C';
WS : SPACE+ {skip();};
SLASH: '\\';
DOT: '.';
LB: '(';
RB: ')';
VAR : [a-z]([a-z0-9'])*;
