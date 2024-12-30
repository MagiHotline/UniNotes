//Scrivere un programma C che apre in scrittura un
//file di cui il nome sia di massimo 30 è chiesto all'utente
//il programma chiede all'utente quanti valori vuole inserire
//li acquisisce e li salva sul file 

#include <stdio.h>

#define N 30

int main() {

    char nomefile[N+1];
    gets(nomefile);

    FILE *f = fopen(nomefile, "w");

    printf("Quanti valori vuoi scrivere?\n");
    int dim;
    
    if(f) { 
        int n;
        scanf("%d", &dim);
        for(int i = 0; i < dim; i++) {
            scanf("%d", &n);
            fprintf(f, "%d ", n);
        }

        fclose(f);
    }



    return 0;
}