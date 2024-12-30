//
// Scrivere un programma dentro al main che acquisisce una stringa, di al più 30 caratteri.
//La copia al rovescio in un secondo array e visualizza il risultato
//

#include <stdio.h>
#include <string.h>

#define DIM 30

int main() {

    //Vediamo come viene implementata strcpy in C

    char str1[DIM+1];
    char str2[DIM+1];
    int i, j = 0;

    for(i = 0; i < DIM; i++) {
        scanf("%s", str1);
    }

    printf("Stringa normale:\n");
    for(i = 0; i < DIM; i++) {
       printf("%s", str1[i]);
    }


    for(i = DIM; i > 0; i--) {
        str2[j] = str1[i];
        //Strcpy?
        j++;
    }


    printf("Stringa rovesciata: %s\n", str2);
    
    return 0;
}