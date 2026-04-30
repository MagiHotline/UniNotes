//Scrivere un programma c che legge in input una sequenza di caratteri
//terminata dal tasto invio e stampi a video e stampa a video in
//ordine invertito
//Il programma stampi anche il numero di caratteri inseriti

#include <stdio.h>

int reverseChar() {
    char c;
    int partialResult;

    c = getchar();

    //10 = "\n"
    if(c == 10) {
        return 0;
    } else {
        partialResult = reverseChar();
        printf("%c", c);
        return partialResult + 1;
    }


}

int main() {




    return 0;
}
