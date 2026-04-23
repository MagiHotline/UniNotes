grammar Magi;

main : exp EOF ;
                                            /* Labels */
exp : FLOAT                                 # val
    | VAR                                   # Access
    | VAR EQUALS exp SEMICOLON              # var
    | VAR EQUALS exp SEMICOLON exp          # seq
    | <assoc=right> exp POW exp             # pow
    | exp op=(MUL | DIV | MOD) exp          # arith2
    | exp op=(ADD | SUB) exp                # arith1
    | LPAR exp RPAR                         # paren
    ;

VAR : [A-Za-z]* ;
fragment LPAR : '(' ;
fragment RPAR : ')' ;
// ARITHMETIC
fragment ADD  : '+' ;
fragment MUL  : '*' ;
fragment SUB : '-' ;
FLOAT : INT | (INT | '-' '0') '.' [0-9]+;
INT : '0' | [-]?[1-9][0-9]* ;
DIV : '/' ;
fragment MOD  : 'mod' ;
fragment POW : '^';
// ASSIGNMENT
fragment EQUALS : '=' ;
fragment SEMICOLON : ';' ;


WS   : [ \t\n\r]+ -> skip ;
