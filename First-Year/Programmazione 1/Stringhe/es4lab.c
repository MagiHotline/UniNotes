#include <string.h>
#include <stdio.h>

#define DIM 10

//Trova la sottostringa in una stringa 
int main() {

    char a[DIM+1]; // 10
    char b[DIM-6]; // 3

    printf("Inserisci la prima parola: ");
    gets(a);
    printf("Inserisci la seconda parola: ");
    gets(b);

    int diverso = 0; 
    int trovato = 0;

    int i, j;
    for(i = 0; i < DIM && (a[i] != '\0' || i < DIM - strlen(b) || trovato == 0); i++) {
        if(a[i] == b[0]) {
            int k = 0;
            for(j = 0; j < strlen(b) || diverso == 0; j++) {
                if(a[k] != b[j]) {
                    diverso = 1;
                    trovato = 0;
                }
                trovato = 1;
                k++;
            }
        }
    }

    if(trovato) printf("Trovato");
    else printf("NON trovato");


    return 0;
}