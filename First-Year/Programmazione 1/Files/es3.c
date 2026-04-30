//Scrivere un programma che apre in lettura un file di testo
//il cui nome di max 30 char è chiesto all'utente
//Il programma legge la sequenza di valori interi salvati nel file
//(la cui lunghezza non è nota) e la visualizza

#include <stdio.h>

#define N 30

int main()
{
    char nomefile[N+1];
    scanf("%s", nomefile);

    FILE *file = fopen(nomefile, "r");

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
