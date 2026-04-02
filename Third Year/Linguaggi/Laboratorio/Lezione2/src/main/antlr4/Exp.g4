grammar Exp;

main : exp EOF ;

exp : NAT | exp ADD exp | exp MUL exp ;
ADD : '+' ;
MUL : '*' ;
NAT : '0' | [1-9][0-9]* ;
