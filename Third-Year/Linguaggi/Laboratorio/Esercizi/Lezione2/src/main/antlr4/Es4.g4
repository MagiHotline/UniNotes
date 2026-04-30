grammar Es4;

main : s EOF ;
s : a w a 'b' ;
a : '1' | '0' ;
w : | '1' | '0' | '_' | '1' w | '0' w | '_' und ;
und : '0' w | '1' w ;
