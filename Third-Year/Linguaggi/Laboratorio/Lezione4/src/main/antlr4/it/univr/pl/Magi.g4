grammar Magi;

main : com EOF ;
                                            /* Labels */
com:  VAR ASSIGN exp                        # var
    | com SEMICOLON com                     # seq
    | IF LPAR exp RPAR LCUR com RBRACE      # if
    | WHILE LPAR exp RPAR LCUR com RCUR     # while
    ;

exp : FLOAT                                 # float
    | BOOL                                  # bool
    | VAR                                   # access
    | <assoc=right> exp POW exp             # pow
    | exp op=(MUL | DIV | MOD) exp          # arith2
    | exp op=(ADD | SUB) exp                # arith1
    | exp op=(EQ | NEQ) exp                 # eqExp
    | exp op=(AND | OR) exp                 # andOr
    | exp op=(LT | LTE | GT | GTE) exp      # cmpExp
    | NOT exp                               # not
    | LPAR exp RPAR                         # paren
    ;

VAR : [A-Za-z]+ ;
LPAR : '(' ;
RPAR : ')' ;
LCUR : '{' ;
RCUR : '}' ;

// COMMANDS
IF: 'if' ;
WHILE: 'while' ;

// ARITHMETIC
FLOAT : INT | (INT | '-' '0') '.' [0-9]+;
fragment INT : '0' | [-]?[1-9][0-9]* ;
ADD  : '+' ;
MUL  : '*' ;
SUB : '-' ;
DIV : '/' ;
MOD  : 'mod' ;
POW : '^';

// LOGIC
BOOL : 'true' | 'false' ;
NOT: '!' ;
EQ: '==' ;
NEQ: '!=' ;
LT: '<' ;
GT: '>' ;
LTE: '<=' ;
GTE: '>=' ;
AND: '&&' ;
OR: '||' ;

// ASSIGNMENT
ASSIGN : '=' ;
SEMICOLON : ';' ;

// STRING LITERALS
STRING : '"' STRCHAR* '"' ;
fragment STRCHAR : ~["\\] | ESC ;
fragment ESC : '\\' [btnfr"'\\] ;

// WHAT TO SKIP: Comments, whitespaces, tabulations, etc.
WS : [ \t\n\r]+              -> skip ;
COMMENT : '/*' .*? '*/'      -> skip ;
LINE_COMMENT : '//' ~[\r\n]* -> skip ;
