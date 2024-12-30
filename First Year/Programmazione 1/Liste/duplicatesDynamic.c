#include <stdio.h>
#include <stdlib.h>
#define D 10

int* eliminaDuplicati(int *num, int *dimDinamica) {

    // 1) Determinare la dimensione del nuovo array
    // 2) Popolare il nuovo array (crearlo dinamicamente)
    int i, duplicato, k, count = 0;
    int *d;
    for(i = 0; i < D; i++) {
        // Per ogni elemento num[i] verifico se è duplicato
        for(k = 0, duplicato = 0; k < D && !duplicato; k++) {
            if(num[k] == num[i]) {
                duplicato = 1;
            }
        }

        // 3 4 5 6 7
        if(!duplicato) {
            count++;
        }
    }


    d = (int*)malloc(count*sizeof(int));
    int j;

    //Inizializzare d
    for(i = 0, j = 0; i < D; i++) {
        for(k = 0, duplicato = 0; k < i && !duplicato; i++) {
            if(num[k] == num[i]) {
                duplicato = 1;
            }
        }

        if(!duplicato) {
            d[j] = num[i];
            j++;
        }
    }

    *dimDinamica = count;

    return d;
}

int main() {



    return 0;
}
