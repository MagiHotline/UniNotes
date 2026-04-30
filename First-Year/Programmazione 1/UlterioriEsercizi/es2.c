#include <stdio.h>
#include <stdlib.h>

typedef struct node {
    int val;
    struct node *next;
} node;


void visualizzaLista(node* lista) {
    while(lista != NULL) {
        printf("%d", lista->val);
        lista = lista->next;
    }
    printf("\n");
}

node* inserisciInCoda(node* lista, int num) {
    node* tmp;
    tmp = (node*)malloc(sizeof(struct node));

    // Verificare l'esito dell'allocazione dinamica
    if(tmp != NULL) {
        tmp->val = num;
        tmp->next = NULL;

        if(lista == NULL) {
            lista = tmp;
        } else {

            node *supp;
            // Scorrere la lista e porta supp all'ultimo nodo della lista corrente
            for(supp = lista; supp != NULL; supp = supp->next);
            supp->next = tmp; // Posiziono il nuovo nodo in fondo alla lista

        }
    } else {
        printf("Memoria esaurita");
    }

    return lista;
}

node* rimuoviDuplica(node *lista) {

    //rimuovi gli elementi in posizione dispari
    //duplica gli elementi in posizioni pari
    node *duplica;
    node *tmp = lista;

    if(lista == NULL) {
        return lista;
    }

    tmp = lista->next;
    free(lista); // il free elimina solo il primo nodo

    while(tmp != NULL) {

        duplica = (node*)malloc(sizeof(struct node));

        duplica->val = tmp->val;

        if(tmp->next != NULL) {

            duplica->next = tmp->next->next;
            free(tmp->next);

        } else {

            duplica->next = NULL;
        }

        tmp->next = duplica;
        tmp = duplica->next;

    }

    return lista;
}


int main() {

    node *testa = NULL;

    testa = inserisciInCoda(testa, 1);
    testa = inserisciInCoda(testa, 2);
    testa = inserisciInCoda(testa, 3);
    testa = inserisciInCoda(testa, 4);

    visualizzaLista(testa);

    testa = rimuoviDuplica(testa);

    visualizzaLista(testa);

    return 0;
}
