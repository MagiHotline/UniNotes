grammar IntExp;
import Nat;

main : exp EOF ;
                                /* Labels */
exp : nat                       # val
    | LPAR exp ADD exp RPAR     # add
    | LPAR exp MUL exp RPAR     # mul
    ;

LPAR : '(' ;
RPAR : ')' ;
ADD  : '+' ;
MUL  : '*' ;

WS   : [ \t\n\r]+ -> skip ;
