//Scrivere una funzione che riceve in ingresso un puntatore ad una lista di interi e la
//modificando memorizzando nell'ultimo nodo il prodotto dell'ultimo per il penultimo
//nel penultimo il prodotto del terzultimo e del penultimo ... sostanzialmente in ogni elemento current * prec
//Il primo nodo non sarà modificato perché non ha antecedente

#include <stdio.h>
#include <stdlib.h>

typedef struct node {
    int dato;
    struct node *next;
} node;


//Ritorna void perché modifica direttamente la lista passata come parametro
void prodottoListe(node* lista) {

    int precValue, currValue;
    node *prec, *current;
    prec = lista;
    precValue = prec->dato;

    while(prec->next != NULL) {
        current = prec->next; //Il corrente diventa il prossimo del precedente
        currValue = current->dato; //Mi mantiene il dato del corrente
        current->dato = currValue*precValue; //Il dato corrente diventa il valore del corrente * precendente
        precValue = currValue; //il valore precedente diventa quello attuale
        prec = current; //Il precedente è quello attuale
    }
}

node* inserisciInCoda(node* lista, int val) {

    //Creare il nuovo nodo
    node* tmp = (node*)malloc(sizeof(struct node));

    if(tmp != NULL) {
        tmp->dato = val;
        tmp->next = NULL;

        // inserire il nuovo
        if(lista == NULL) {
            lista = tmp;
        } else {
            node* current = lista;
            for(current = lista; current->next != NULL; current = current->next);
            current->next = tmp;
        }

    } else {
        printf("Memoria esaurita");
    }

    return lista;
}

void view(node* lista) {
    while(lista != NULL) {
        printf("%d ", lista->dato);
        lista = lista->next;
    }
    printf("\n");
}


int main() {

    int val;

    node* lista = NULL;

    do {
        scanf("%d", &val);
        if(val != -1) {
            lista = inserisciInCoda(lista, val);
        }

    } while(val != -1);

    view(lista);
    prodottoListe(lista);
    view(lista);


    return 0;


}
