//Scrivere un pogrammma che acquisisce una stringa s1 di massimo 50 caratteri e ne restituisce una nuova
//s2 copiando il contenuto di s1 e sostituendo le vocali con il carattere '*';

#include <stdio.h>
#include <string.h>

#define DIM 50

int main() {

    char str1[DIM+1];
    char str2[DIM+1];
    int i, j;

    gets(str1);
    //scanf("%s", str1);

    printf("Stringa normale: %s\n", str1);

    for(i = 0, j = 0; str1[i] != '\0'; i++) {
        //Inserire anche il maiuscolo
        if(str1[i] != 'a' && str1[i] != 'e' && str1[i] != 'i' && str1[i] != 'o' && str1[i] != 'u') {
            str2[j] = str1[i];
            j++;
        } 
    }

    str2[j] = '\0';

    printf("\nStringa nuova: %s", str2);

    return 0;
}