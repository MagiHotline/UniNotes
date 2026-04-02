grammar Es1;
import Seq;

// Given the alphabet Dig = {0, 1, . . . , 9}
// Define a context-free grammar to generate the language
// of all lists of decimal digits

main : dig EOF ;

dig : '(' seq ')' ;
seq : | '0, ' seq | '1, ' seq | '2, ' seq | '3, ' seq | '4, ' seq | '5, ' seq | '6, ' seq | '7, ' seq | '8, ' seq | '9, ' seq | '0' | '1' | '2' | '3' | '4' | '5' | '6' | '7' | '8' | '9' ;
