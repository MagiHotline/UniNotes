grammar IntExp;

main : exp EOF ;
                                    /* Labels */
exp : INT                           # val
    | VAR EQUALS exp SEMICOLON      # var
    | LPAR exp ADD exp RPAR         # add
    | LPAR exp MUL exp RPAR         # mul
    | LPAR exp SUB exp RPAR         # sub
    | LPAR exp DIV exp RPAR         # div
    | LPAR exp MOD exp RPAR         # MOD
    ;

VAR : [a-z]* ;
INT : '0' | [-]?[1-9][0-9]* ;
LPAR : '(' ;
RPAR : ')' ;
// ARITHMETIC
ADD  : '+' ;
MUL  : '*' ;
SUB : '-' ;
DIV : '/' ;
MOD  : 'mod' ;
// ASSIGNMENT
EQUALS : '=' ;
SEMICOLON : ';' ;


WS   : [ \t\n\r]+ -> skip ;
