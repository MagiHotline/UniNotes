// Scrivere un sottoprogramma in C che date 2 stringhe le concatena salvandole il risultato in una stringa che occupa esattamente lo spazio necessario

#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#define LINE 255
char *concat(char *s1, char *s2) {
    int i,j;
    char *s3 = (char *)malloc(strlen(s1) + strlen(s2) + 1);
    //verificare che l'allocazione sia andata a buon fine
    if(!s3)
    {
        printf("ERRORE");
    } else {
        s3 = strcat(s1, s2);
        for(i = 0; i < strlen(s1); i++) {
            *(s3+i) = *(s1+i);
        }

        for(j = 0; j < strlen(s2); j++) {
            *(s3+i+j) = (*s2+j);
        }

    }


    return s3;
}

int main() {


    return 0;
}
