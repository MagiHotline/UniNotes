//Scrivere un progrmama che chiede all'utente una sequenza di lunghezza indefinita di numeri positivi
//terminata da un valore non positivo. Il programma conta per ciascun valore della sequenza il numero
//di divisori propri diversi da sè stessi e salvi il risultato in un file su ogni riga, la coppia valore letto: numero di divisori propri

#include <stdio.h>

int divisoriPropri(int);

int main() {

    FILE *file = fopen("es8.txt", "w");
    int n, count = 0, res;
    if(file) {
        scanf("%d", &n);
        while(n > 0) {
            res = divisoriPropri(n);
            fprintf(file, "%d %d\n", n, res);
            scanf("%d", &n);
        }

        fclose(file);
    } else {
        printf("Errore: Cannot open file");
    }
    return 0;
}

int divisoriPropri(int n) {

    int count = 0;

    for(int i = 1; i < n; i++) {
        if(n % i == 0) {
            count++;
        }
    }

    return count;
}