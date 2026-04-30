// Matrice in memoria dinamica => Linearizzazione

#include <stdio.h>
#include <stdlib.h>

int main() {

    int r,c; //*righe, *colonne
    int *mat;

    printf("Inserisci righe e colonne: ");
    scanf("%d %d", &r, &c); //Spazio in memoria? R*C*sizeof(int)

    mat = (int*)malloc(r*c*sizeof(int)); // Puntatore al primo elemento della matrice
                                         // Puntatore all'inizio dell'heap

    // RIGA 0   3 4
    // RIGA 1   6 1
     for(int i = 0; i < r; i++) {
         for(int j = 0; j < c; j++) {
             printf("Elemento riga %d, colonna %d", i, j);
             scanf("%d", &mat[i*c+j]);
         }
     }

     // Stampiamo la matrice

    for(int i = 0; i < r; i++) {
        for(int j = 0; j < c; j++) {
            printf("%d", mat[i*c+j]);
        }
    }

    free(mat);
    return 0;
}
