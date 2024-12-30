//Scrivere un programma che apre "ciao.txt" che contiene
//Una sequenza di numeri lunghezza NON nota.

#include <stdio.h>

int main()
{
    FILE *file = fopen("ciao.txt", "r");

    if(!file) {
        printf("Cannot Open File\n");
    } else {
        int n;

        while(!feof(file)) {
            fscanf(file, "%d ", &n);
            printf("%d ", n);
        }

        fclose(file);
    }

    return 0;
}
