/*

Scrivere un programma C che dato un numero N
calcola la somma dei primi n numeri pari positivi in maniera
ricorsiva

*/

int sommaPari(int n) {

    if(n % 2 != 0) {
        return sommaPari(n-1);
    } else if(n <= 1) {
        return 2;
    } else {   
        return n + sommaPari(n-2); 
    } 
}

//SOLUZIONE PROF

int somma_pari(int n) {
    if(n == 1) return 2;
    else return (2*n + sommaPari(n-1));
}


#include <stdio.h>

int main() {

    printf("%d\n", sommaPari(1));
    return 0;
}