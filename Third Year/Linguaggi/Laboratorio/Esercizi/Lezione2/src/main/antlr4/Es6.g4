grammar Es6;

main : s EOF ;

s : | a | b ;
a : | '0' a '1' ;
b : | '0' b '11' ;
