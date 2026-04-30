grammar Es2;
import Seq;

// Now consider, for all k ∈ N, the following recursive definition
// Define a context-free grammar to generate the language
// of all recursive lists of decimal digits

main : dig EOF ;

dig : '(' seq '), ' dig | '(' seq ')' ;
seq : | '0, ' dig | '1, ' dig | '2, ' dig | '3, ' dig | '4, ' dig | '5, ' dig | '6, ' dig | '7, ' dig | '8, ' dig | '9, ' dig | '0, ' seq | '1, ' seq | '2, ' seq | '3, ' seq | '4, ' seq | '5, ' seq | '6, ' seq | '7, ' seq | '8, ' seq | '9, ' seq | '0' | '1' | '2' | '3' | '4' | '5' | '6' | '7' | '8' | '9' ;
