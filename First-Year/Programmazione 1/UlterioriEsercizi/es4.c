//funzione conta che riceve due parametri

// matrice mat di interi nxm note a priori
// array v di cui conosciamo la dimensione < M
// array b + la sua dimensione

#include <stdio.h>

#define ROW 5
#define COL 7

int main() {

    int mat[ROW][COL] = {{10, 4, 7, 3, 8, 4, 5}, {2,1,3,6,1,5,9}, {1,17,8,5,4,3,8}, {3,7,5,8,7,8,4}, {1,3,8,2,5,5,6}};

    int b[] = {3, 8, 5};

    for(int i = 0; i < ROW; i++) {
        for(int j = 0; j < COL; j++) {
            printf("%d ", mat[i][j]);
        }
        printf("\n");
    }

    int dim = 3;
    int ok;
    int count = 0;
    int countcc = 0;
    for(int j = 0; j < COL; j++) {
        for(int i = 0, flag = 0; i < ROW - dim + 1; i++) {
            count = 0;
            for(int k = 0; k < dim; k++) {
                if(mat[i+k][j] == b[k]) {
                    count++;
                }
            }

            if(count == dim) {
                countcc++;
            }
        }

    }

    printf("\nNumero di volte: %d\n", countcc);

    return 0;
}
