#include <stdio.h>

int main() {
    
    // Eravamo abituato ad essagnare a degli indirizzi dei nomi
    // int x = 5; -> fa riferimento al VALORE 5 allocata in memoria
    // Un puntatore è sempre una variabile che però contiene un indirizzo di memoria
    int *ptr; 

    //Assegniamo un valore alla variabile di tipo puntatore 
    int a;
    ptr = &a;
    //Accesso al contenuto all'area di memoria puntata


    int *p, *q;

    p =  q; //Ora entrambi puntano alla stessa cella dimemoria
    *p = *q; //Sovrascrive i puntatori.

    //

    return 0;
}