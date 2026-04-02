grammar Es3;

main : s EOF ;
s : a '1' a '1' a '1' a '1' a ;
a : | '0' | '1' | '0' a | '1' a ;
