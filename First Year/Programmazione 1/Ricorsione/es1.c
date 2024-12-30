// Scrivere una funzione ricorsiva int ric(int x) che calcola ricorsivamente
// La somma i numeri compresi fra 0 e x 


#include <stdio.h>

int ric(int x) {
    if(x == 0) return 0;
    else return x + ric(x-1);
}

int main() {

    printf("%d", ric(5));

    return 0;
}