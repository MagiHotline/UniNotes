
#include <stdio.h>
#include <string.h>

//IL CASO BASE NON SOLO DEVE ESSERCI MA DEVE VERIFICARSI
int isPalindromoRic(char *first, char *last) {
    if(first >= last) {
        return 1;
    } else {
        if(*first != *last) {
            return 0;
        } else {
            return isPalindromoRic(first+1, last-1);
        }
    }

}

#define N 10
int main() {

    char s[N+1];

    scanf("%s", s);

    isPalindromoRic(s, s+N);


    return 0;
}
