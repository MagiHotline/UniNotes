//Scrivere un programma C che riceve in ingresso due numeri interi e restituisce 
//attraverso i parametri  passati per indirizzo sia il massimo che il minimo

#include <stdio.h>

void maxmin(int, int, int*, int*);

int main() {

    int a, b, max, min;

    scanf("%d", &a);
    scanf("%d", &b);

    maxmin(a,b,&min,&max);

    printf("max: %d, min: %d", max, min);

    return 0;
}

void maxmin(int a, int b, int *min, int *max) {

    if(a > b) {
        *max = a;
        *min = b;
    } else {
        *max = b;
        *min = a;
    }
}