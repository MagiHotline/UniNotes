//Scrivere una funzione listeUguali che accetta in Input 2 liste uguali che accett in inout due lista
//l1 e l2 che possono essere vuote e restituisce 0 se sono uguali
//1 se l1 > l2 => in posizione i l1[i] > l2[i]
//-1 otherwise

#include <stdio.h>
#include <stdlib.h>

typedef struct node {
    int val;
    struct node* next;
}node;

int listeUguali(node* l1, node* l2) {


    if(l1 == NULL && l2 == NULL) {
        return 0;
    } else {
        while((l1->next != NULL && l2->next != NULL) && (l1->val == l2->val)) {
            l1 = l1->next;
            l2 = l2->next;
        }

        if(l1->next != NULL && l2->next != NULL) {
            // Sono uscita dal while perché il dato era diverso l1->val != l2->val
            if(l1->val > l2->val) {
                return 1;
            } else {
                return -1;
            }
        } else if(l1->next != NULL) {
            if(l1->val == l2->val) {
                return 1;
            } else if(l1->val > l2->val) {
                return 1;
            } else {
                return -1;
            }
        } else if(l2->next != NULL) {
            if(l1->val == l2->val) {
                return -1;
            } else if(l2->val > l1->val) {
                return 1;
            } else if(l1->val < l2->val){
                return -1;
            }
        }

        return 0;
    }
}

//in questo caso 1 = UGUALI, 0 = diverse
int listeUgualiR(node* l1, node* l2) {

    if(l1 == NULL || l2 == NULL) {
        return (l1 == NULL && l2 == NULL);
    } else {
        //Passo induttivo
        if(l1->val == l2->val) {
            return listeUgualiR(l1->next, l2->next);
        } else {
            return 0;
        }
    }


}


int main() {


    return 0;
}
