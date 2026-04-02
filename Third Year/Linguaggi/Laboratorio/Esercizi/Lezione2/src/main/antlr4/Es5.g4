grammar Es5;

// abcc
main : s EOF ;
s : | a b ;
a : | 'a' a b 'c' ;
b : | 'b' b 'c' ;
