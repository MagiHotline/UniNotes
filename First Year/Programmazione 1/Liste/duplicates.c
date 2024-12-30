// Scrivere un programma C che crea una copia di un array senza duplicati

#include <stdio.h>

#define D 10

int main() {

    int A[D]; // Input
    int B[D]; // Output

    int i, j, k = 0;
    int duplicato;
    for(i = 0; i < D; i++)
    {
        scanf("%d", &A[i]);
    }

    for(i = 0; i < D; i++) {
        // Verifico se è già stato inserito l'elemento corrente
        duplicato = 0;
        for(j = 0; j < D && !duplicato; j++) {
            if(A[i] == A[j]) {
                duplicato = 1;
            }
        }

        if(!duplicato) {
            B[k] = A[i];
            k++;
        }

    }



    return 0;
}
