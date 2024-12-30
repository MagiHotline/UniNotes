
#include <stdio.h>
#include <stdlib.h>

typedef struct node {
   int val;
   struct node* next;
}node;

void listDestroy(node *lista) {
    if(lista != NULL) {
        listDestroy(lista->next);
        free(lista);
    }
}


int main() {

    return 0;
}
