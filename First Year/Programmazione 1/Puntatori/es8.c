//Scrivere un sottoprogramma C che riceve come parametri un array di interi e la sua dimensione
//e sostituisce ciascun valore negativo presente all'interno dell'array con il suo valore assoluto;
//USare il sottoprogramma nel main
#include <stdio.h>

#define DIM 10

void replaceNeg(int[], int);
void assoluto(int*, int);

int main() {

    int a[DIM];
    int i;

    for(i = 0; i < DIM; i++) {
        scanf("%d", &a[i]);
    }
    
    replaceNeg(a, DIM);

    for(i = 0; i < DIM; i++) {
        printf("%d ", a[i]);
    }

    return 0;
}

void replaceNeg(int a[], int dim) {
    for(int i = 0; i < dim; i++) {
        if(a[i] < 0) a[i] = -a[i];
    }
}

void assoluto(int *a, int dim) {
    for(int i = 0; i < dim; i++) {
        if(*(a+i) < 0) *(a+i) = -(*(a+i));
    }
}