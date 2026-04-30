// creare dinamiamente array con dim data dall'utente
// riempire l'array con dei numeri casuali da 0 a 9 compresi
// contare quanti multipli di tre sono presente negli array;
// riallocare l'array aggiungendo 1 elemento e mettere in ultima posizione
// il numero di multipli di 3 contati;
// riallochiamo di nuovo aggiungendo un altro elemento e mettere in prima posizione
// il # di multipli di 3 contati


#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main() {

    int dim;
    int count;

    printf("Inserisci dimensione: ");
    scanf("%d", &dim);

    // alloco dinamicamente in memoria per l'array'
    int *array = (int*)malloc(dim*sizeof(int));

    srand(time(NULL));

    for(int i = 0; i < dim; i++) {
        array[i] = rand() % 10;

        if(array[i] % 3 == 0) {
            count++;
        }
    }

    printf("Il numero di multipli di tre: %d", count);

    //Aggiungiamo un po' di spazio, non modificando i valori e riallocando
    array = (int*)realloc(array, (dim+1)*sizeof(int));

    array[dim] = count;

    //riallochiamo
    array = (int*)realloc(array, (dim+2)*sizeof(int));

    // Shifto a destra

    for(int i = dim+1; i > 0; i--) {
        array[i] = array[i-1];
    }

    array[0] = count;




    return 0;
}
