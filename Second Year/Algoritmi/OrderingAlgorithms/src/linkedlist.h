//definire una struttura dati lista concatenata con una serie di operazioni
//tra cui: inserimento, cancellazione, ricerca e così via (CRUD) Create, Retrieve, Update, Delete
#include <stdio.h>
#include <stdlib.h>

struct node {
    int num;
    struct node *next; // Struttura ricorsiva
};

// Inserimento in coda
struct node* inserisciInCoda(struct node*, int); //oppure anche void
//Inserimento in testa
struct node* inserisciInTesta(struct node* , int); //lista aggioranta
//Inserisci in maniera ordinata
struct node* inserisciOrdinato(struct node*, int);
//Rimuovi un elemento
struct node* rimuovi(struct node*, int);
//Visualizza gli elementi della lista
void view(struct node*);
//Svuota la lista
struct node* destroy(struct node*);
//Ricerca
int esisteElemento(struct node*, int);
//Massimo
int massimo(struct node*);


struct node* inserisciInCoda(struct node *list, int value) {

    //Alloca lo spazio di memoria per il memorizzare al nuovo elemento
    struct node* newNode = (struct node*)malloc(sizeof(struct node));

    if(!newNode) {
        printf("Memoria esaurita!\n");
        return list;
    } else {
        newNode->num = value;
        newNode->next = NULL;

        if(list != NULL) {
            list = newNode;
        } else {

            struct node *current = list;
            while(current->next != NULL) {
                current = current->next;
            }

            current->next = newNode;
        }

    }


    return list;
}

struct node *inserimentoInTesta(struct node* list, int value) {
    struct node* tmp;
    tmp = (struct node*)malloc(sizeof(struct node));

    if(tmp != NULL) {
        tmp->num = value;
        tmp->next = list;
        list = tmp;
    } else {
        printf("Memoria esaurita");
    }

    return list;
}

struct node* inserimentoOrdinato(struct node* list, int value) {

    struct node* newNode;
    struct node *current;
    newNode = (struct node*)malloc(sizeof(struct node));
    if(!newNode) {
        newNode->num = value;

        if(newNode == NULL) {
            newNode->next = list;
            list = newNode;
        } else {

            //Se il numero da inserire è più piccolo o minore uguale del primo elemento della lista, inserimentp in testa
            if(newNode->num <= list->num) {
                newNode->next = list;
                list = newNode;
            } else if(list->next == NULL) {
                newNode->next = NULL;
                list->next = newNode;
            } else {

                //All'inizio current punta al primo elemento e finché non è arrivato alla fine e il numero è maggiore del valore del prossimo nodo
                //Proseguo a scorrere la lista
                for(current = list; current->next != NULL && (newNode->num > current->next->num); current = current->next);

                newNode->next = current->next; //facciamo puntare il link al prossimo del current
                current->next = newNode; //il link del prossimo sarà uguale a temp
            }
        }
    }

    return list;
}

//Visualizza l'intera lista
void view(struct node* list) {
    struct node* current = list;
    while(current != NULL) {
        printf("%d", current->num);
        current = current->next;
    }
    printf("\n");
}

struct node* destroy(struct node* list) {
    struct node* current = list;
    struct node* prox;
    while(current != NULL) {
        prox = current->next;
        free(current);
        current = prox;
    }
    return NULL;
}

//Esiste un elemento n->return 1 altrimento return 0 = false
int esisteElemento(struct node* list, int value) {
    struct node* current = list;
    while(current != NULL) {
        if(value == current->num) {
            return 1;
        }
        current = current->next;
    }

    return 0;
}



struct node* rimuovi(struct node* list, int value) {

    struct node* current = list;
    struct node* prec = NULL; //Nodo precedente
    int found = 0;
    while(current != NULL && !found) {

        if(current->num == value) {
            found = 1;
            if(prec != NULL) {
                prec->next = current->next;
            } else {
                list = current->next;
            }

            free(current);

        } else {
            prec = current;
            current = current->next;
        }


    }
    return list;
}

struct node* concatenateLists(struct node **lists, int k) {
    struct node *result = NULL;  // Head of the concatenated list
    struct node *tail = NULL;    // Tail pointer for efficient appending

    for (int i = 0; i < k; i++) {
        struct node *current = lists[i];
        // If the current list is empty, skip it
        if (current == NULL) continue;

        // If result is empty, initialize it with the current list
        if (result == NULL) {
            result = current;
        } else {
            // Otherwise, attach the current list to the tail of result
            tail->next = current;
        }

        // Update the tail to the end of the current list
        while (current->next != NULL) {
            current = current->next;
        }
        tail = current;  // Update tail to the end of the last list appended
    }

    return result;
}

// Function that converts a linked list to an array
int* linkedListToArray(struct node *head, int size) {
    int *array = (int*)malloc(size * sizeof(int));
    struct node *current = head;
    for (int i = 0; i < size; i++) {
        array[i] = current->num;
        current = current->next;
    }

    return array;
}

int massimo(struct node* list) {

    struct node* current = list;
    int max;
    if(list != NULL) {
        max = current->num;
        current = current->next;

        while(current!=NULL) {
            if(current->num > max) {
                max = current->num;
            }
            current = current->next;
        }
        return max;

    } else {
        printf("Lista vuota");
        return 0;
    }
}
