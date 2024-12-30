
#include <stdio.h>

typedef struct node {
   int val;
   struct node* next;
}node;

int listLenght(node *lista) {
    if(lista == NULL) {
        return 0;
    } else {
        return 1 + listLenght(lista->next);
    }
}


int main() {


    return 0;
}
