grammar Es5;

// abcc
main : a EOF ;
a : 'a' a 'c' | b;
b : | 'b' b 'c' ;
