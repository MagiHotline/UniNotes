// Scrivere un programma c che inverta le cifre di un numero intero n usando un'apposita
//funzione ricorsiva 

// n = 4325 -> 5324

int invert(int n, int part) {
    int result = 0;
    if(n == 0) {
        return part;
    } else {
        return invert(n/10, (part*10 + n%10));
    }
}
#include <stdio.h>
int main() {

    int n = 4325;
    
    printf("%d\n", invert(n, 0));
    return 0;
}