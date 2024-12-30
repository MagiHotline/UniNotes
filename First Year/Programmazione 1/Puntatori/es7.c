
//Scrivere una funzione che riceve come parametri un array di interi e la sua dimensione
//Il sottoprogramma calcola la somma dei valori contenuti nell'array, e ritorna il risultato
//Scrivere un programma che richiede all'utente 10 valori, invoca la funzione e stampa il ris

int sommaArray(int*, int);
int sommaArray2(int[], int);


#include <stdio.h>
int main(){

    int dim = 10;
    int a[dim];
    for(int i = 0; i < dim; i++){
        scanf("%d",&a[i]);
    }

    int ris = sommaArray(a,dim); 

    //ALTERNATIVA STAMPIAMO I VALORI DELLA PRIMA metà di un array1 e sommma array della seconda metà
    int s1 = 0, s2 = 0;
    s1 = sommaArray2(a, dim/2);
    s2 = sommaArray2(&a[dim/2], dim/2); 
    //s2 = sommaArray2(*(a + dim/2), dim/2); 


    printf("%d\n",ris);

    return 0;
}

int sommaArray(int *a, int dim) {
    int i, somma = 0;
    for(i = 0; i < dim; i++) {
        somma += *(a+i);
    }

    return somma;
}

int sommaArray2(int a[], int dim) {
    int i, somma = 0;
    for(i = 0; i < dim; i++) {
        somma += a[i];
    }

    return somma;
}