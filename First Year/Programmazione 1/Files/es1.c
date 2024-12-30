//Scrivere un programma in C che apre un file "ciao.txt" in scrittura e scrive i numeri da 1 a 10

#include <stdio.h>

int main() {

    FILE *file = fopen("ciao.txt", "w");  

    if(file == NULL) {
        printf("Error: cannot open file");
    } else {

        for(int i  = 1; i <= 10; i++) {
            fprintf(file, "%d ", i); 
        }

        fclose(file);
    }

    return 0;
}