#include <stdlib.h>
#include <stdio.h>

int main() {

    int *ptr;
    int i;
    int quanti;
    printf("Quanti elementi? ");
    scanf("%d", &quanti);

    ptr = (int *)malloc(quanti*sizeof(int));
    // ptr = (int *)calloc(quanti, sizeof(int));

    if(!ptr) {
        printf("ERROR");
    } else {
        for(i = 0; i < quanti;i++) {
            printf("Elemento: ");
            scanf("%d", &ptr[i]);
        }

        for(i = 0; i < quanti; i++) {
            printf("%d ", ptr[i]);
        }
    }

    free(ptr);

    return 0;
}
