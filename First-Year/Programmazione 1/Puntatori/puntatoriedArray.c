#include <stdio.h>

int main() {

    /*in C, ci sta una stretta correlazione tra array e puntatore.
    Il nome di una variabile array (es. a) è una costante di tipo puntatore
    al tipo componente dell'array il cui valore è l'ìndirizzo del 
    primo elemento dell'array.

    int a[3]; //array di interi di dimensione 3 ma "a" è un puntatore costante
            //di tipo int il cui valore è &a[0] -> a = &a[0]

    int *p;

    p = p + 1; //Sto cambiando l'ìndirizzo di memoria 

    a[i] == *(a+i);
    */

   int a[5];
   int i;
   int *p;

    a[i]; //Accesso all'i-esimo elemento dell'array a
    *(a+i); //Spostando a partire dal 1 elemento di a, di i posizioni, accesso al valore.

    p = a; //-> equivalente a scrivere che sto assegnando al puntatore l'indirizzo del primo elemento di a
    //a = p; //-> ERRORE perché a è costante. non è modificabile
    //a = a + i -> ERRORE perché a è costante, non è modificabile

    /*
    
    se io definisco

    int *a; //PUNTATORE
    int *const a; //PUNTATORE COSTANTE
    const int *a; //PUNTATORE COSTANTE a DATI COSTANTI
    const int *const a; //PUNTATORE COSTANTE A DATI COSTANTI
    */

    int *punt, arr[10]; //PUNT è un puntatore ad interi, ARR è un array ma è anche un PUNTATORE al primo elemento
     // = &arr[0] ed è una costante quindi non lo posso modificare. 

    punt = arr; //punt non è un valore costante quindi posso cambiarlo.

    *punt = 9; //arr[0] = 9
    punt = punt + 2; // SPOSTAMENTO -> PUNT = &arr[2]
    *punt = 7; //arr[2] = 7
    *(punt+1) = 17; //arr[3] = 17
    //il valore di punt non è cambiato.

    /*
    
    ARRAY MULTIDIMENSIONALI
    void func (int a[][N], ...)

    Un array a di elementi dove ciascun elemento è un array di interi di dim N
    generale su # di elementi dell'array
    specifico sul tipo degli elementi dell'array

    NON SI PUò USARE IL TIPO ARRAY COME VALORE DI RITORNO.

    */

    return 0;
}