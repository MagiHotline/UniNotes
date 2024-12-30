//Creare un programma C che calcola la radice quadrata intera di un numero intero positivo.
//Il sottoprogramma riceve come parametro il numero intero positivo e un'altra variabile
//passata come indirizzo in cui memorizzare la radice intera. Il sottoprogramma ritorna
//1 se la radice è precisa oppure 0


#include <stdio.h>

int sqrt(int, int*);


int main() {

    int x, radice;
    scanf("%d", &x);

    if(sqrt(x, &radice)) {
        printf("%d", radice);
        printf("\nLa radice è' precisa");
    } else {
        printf("%d", radice);
        printf("\nLa radice NON è' precisa");
    }

    return 0;
}

int sqrt(int x, int *root) {
    
    *root = 1;
    while((*root) * (*root) <= x) {
        (*root)++;
    }


    (*root)--;
    return (*root)*(*root) == x;
}


