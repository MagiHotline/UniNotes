//funziona che data una stringa s costruiscela la lista corrispondente
#include <stdio.h>
#include <stdlib.h>

struct node_t {
    char data;
    struct node_t* next;
};

typedef struct node_t node;

node* makeString(char *s) {

    node* head = NULL; // ->

    node* current;
    node* prev;

    while(*s != '\0') {
        // Creazione di un nuovo nodo
        current = (node*)malloc(sizeof(node));

        if(current != NULL) {

            current->data = *s;
            current->next = NULL;

            if(head == NULL) {
                // Se la testa è vuota, la testa punta al corrente
                head = current;
            } else {
                prev->next = current;
                s++; // Itero sulla stringa
            }

        }
    }

    return head;
}

int main() {


    return 0;
}
