#include <string.h>
#include <stdio.h>

#define DIM 50
int main() {

    char s1[DIM+1];
    char s2[DIM+1];
    char s3[2*DIM+1];


    printf("Inserisci la prima parola: ");
    gets(s1);
    printf("Inserisci la seconda parola: ");
    gets(s2);
    
    //printf("%s", strcat(s1, s2));

    int i, j;
    for(i = 0; i < DIM && s1[i] != '\0'; i++) {
        s3[i] = s1[i];
    }

    for(j = 0; j < DIM && s2[i] != '\0'; j++) {
        s3[i+j] = s2[j];
    }

    s3[DIM-1] = '\0';

    printf("Stringa concatenata:  ");
    printf("%s", s3); 


    return 0;
}