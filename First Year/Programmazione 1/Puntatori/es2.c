//Scrivere un programma C che calcola il risultato della divisione intera tra due 
//numeri 

#include <stdio.h>

void divInt(int, int, int*, int*);

int main() {

    int a, b, ris, resto;

    scanf("%d", &a);
    scanf("%d", &b);

    divInt(a, b, &ris, &resto);

    printf("Il risultato della divisione intera tra %d e %d e': %d con resto di %d", a, b, ris, resto);

    return 0;
}

void divInt(int a, int b, int *quoz, int *resto) {
    *quoz = a/b;
    *resto = (a%b);
}