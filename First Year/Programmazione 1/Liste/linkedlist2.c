//Scrivere un programmma C che lavora di liste di interi e usa una funzione
// "prodotto" che calcola il prodotto dei valori contenuti nella lista
// -> versione iterativa
// -> versione ricorsiva

#include <stdio.h>
#include <stdlib.h>

typedef struct node {
    int dato;
    struct node *next;
} node;

    //il puntatore è passato per copia
int prodotto(struct node *lista) {
    int prodotto = 1;

    while(lista != NULL) {
        prodotto = prodotto * lista->dato;
        lista = lista->next;
    }


    return prodotto;
}

int prodottoR(struct node *lista) {
    if(lista == NULL) {
        return 1;
    } else {
        return lista->dato * prodotto(lista->next);
    }
}


int main() {


}
