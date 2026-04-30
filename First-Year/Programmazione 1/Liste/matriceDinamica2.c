#include <stdio.h>
#include <stdlib.h>

int main() {

    int i,j;
    int **p;
    int r, c;

    printf("Quante righe e colonne vuoi inserire? ");
    scanf("%d %d", &r, &c);

    //allochiamo memoria nello heap;
    //Memorizziamo un array di puntatori di r elementi
    //Memorizziamo r puntatori a interi di c elementi

    p = (int**)malloc(r*sizeof(int*)); //ogni elemento è un puntatore all'area di memoria che assume i puntatori come singole righe
    //sono r elementi di puntatore a puntatore a intero

    for(int i = 0; i < r; i++) {
        p[i] =(int*)malloc(c*sizeof(int)); // Area di memoria per ciascuna riga della matrice
    }

    for(int i = 0; i < r; i++) {
        for(int j = 0; j < c; j++) {
            scanf("%d", &p[i][j]);
        }
    }

    free(p);

    return 0;
}
