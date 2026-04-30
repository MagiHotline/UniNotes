//Scrivere un programma c che calcola la stampa a video quanti quadrati perfetti
//sono presenti nel file

#include <stdio.h>

#define N 30
#define filename "sqrt.txt"

int main()
{   
    
    FILE *file  = fopen(filename, "r");
    int n;
    int i, ok, count = 0;
    if(file) {
        while(!feof(file)) {  
            fscanf(file, "%d", &n);
            for(i = 1, ok = 0; i <= n && !ok; i++) {
                if(n == i) {
                    ok = 1;
                }
            }
            
            if(ok) count++;
        }
        
        printf("Ci sono %d quadrati perfetti\n", count);
        fclose(file);
    } 



    return 0;
}
