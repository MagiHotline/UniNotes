//scrivere un sottoprogramma che riceve due interi positivi e calcola l'elevamento
//a potenza del primo rispetto al secondo, restituendo il risultato;
//scrivere un sottoprogramma che calcola il log in base 2 intero di un numero intero positivo
//Il sottoprogramma prende come argomenti la variabile contentente il numero ed una variabile in cui salvare il risultato.
//Il sottoprogramma restituisce 1 se il log intero è preciso, 0 se non lo è.
//Scrivere un programma che utilizza tale sottoprogramma per calcolare
//il logaritmo in base 2 di un intero inserito dall'utente e ne visualizza il risultato. 

#include <stdio.h>

int pot(int, int);
int logtwo(int, int*);

int main() {

    int a, ris, b;

    scanf("%d", &a);

    b = logtwo(a, &ris);
    printf("%d %d", ris, b); //b is boolean
    return 0;
}

int pot(int n, int k) {

    int ris = 1;
    //Controllare che i e k non siano negativi, altrimenti return -1
    for(int i = 0; i < k; i++) {
        ris = ris * n;
    }

    return ris;
}

int logtwo(int n, int *ris) {

    //controllare che n e *ris siano positivi, altrimenti return -1
    *ris = 0;
    while(!(pot(2, *ris+1) > n)) {
        (*ris)++; //Ricordare le parentesi
    }

    return (pot(2, *ris) == n);
}


