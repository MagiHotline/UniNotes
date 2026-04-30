#include <stdio.h>
#include <stdlib.h>

// n  > 0 => Scomporre N => per ogni cifra di N creare c elementi con valore c da aggiungere in coda alla lista
// Positivo -> Inserimenti in testa
// Negativo -> Inserimento in Coda

typedef struct node {
    int val;
    struct node* next;
} node;

node* inserisciInTesta(node* lista, int val) {
    node *tmp = (node*)malloc(sizeof(struct node));

    if(tmp != NULL) {
        tmp->val = val;
        tmp->next = lista;
        lista = tmp; //Aggiorna il puntatore della testa
    } else {
        printf("Memoria esaurita");
    }

    return lista;
}


node* inserisciInCoda(node* lista, int val) {

    //Creare il nuovo nodo
    node* tmp = (node*)malloc(sizeof(struct node));

    if(tmp != NULL) {
        tmp->val = val;
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

node* int2list(int n) {
    int c, i;
    node *lista = NULL;

    if(n > 0) {
        while(n != 0) {
            c = n % 10;
            n = n / 10;
            for(i = 0; i < c; i++) {
                lista = inserisciInTesta(lista, c);
            }
        }
    } else {
        n = -n;
        while(n != 0) {
            c = n % 10;
            n /= 10;
            for(i = 0; i < c; i++) {
                lista = inserisciInCoda(lista, c);
            }
        }
    }

    return lista;
}

void view(node* lista) {
    while(lista != NULL) {
        printf("%d ", lista->val);
        lista = lista->next;
    }
    printf("\n");
}


int main() {

    node* lista = NULL;
    lista = int2list(-32);
    view(lista);

    return 0;
}
