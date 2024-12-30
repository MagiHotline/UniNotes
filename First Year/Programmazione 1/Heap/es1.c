#include <stdio.h>

int multiplier = 1; // Può essere utilizzata sia (r,w) da tutte le funzioni successive

int mult(int a) {
    return a*multiplier; // Uso in lettura della variabile globale
}

void changeMultiplier(int m) {
    multiplier = multiplier * m; // Uso in scrittura della variabile globale
}


int main() {

    int a = 5; //Variabile globale

    changeMultiplier(10);
    printf("%d*%d = %d\n", a, multiplier, mult(a));
    changeMultiplier(8);
    printf("%d*%d = %d", a, multiplier, mult(a));

    return 0;
}
