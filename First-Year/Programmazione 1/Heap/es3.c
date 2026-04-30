// Scrivere un programma che inizializza e stampa il contenuto di una matrice definita tramite una vara globale

#include <stdio.h>

#define N 3

//var glbal
int m[N][N];

void inserisci();
void stampa();


int main() {


    inserisci();
    stampa();



    return 0;
}

void inserisci() {
    int i, j, x;
    for(i = 0; i < N; i++) {
        for(j = 0; j < N; j++) {
            scanf("%d", &x);
            m[i][j] = x;
        }
    }
}

void stampa() {
    int i, j;
    for(i = 0; i < N; i++) {
        for(j = 0; j < N; j++) {
            printf("%d", m[i][j]);
        }
        printf("\n");
    }
}
