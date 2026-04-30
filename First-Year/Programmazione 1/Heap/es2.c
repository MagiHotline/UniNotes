#include <stdio.h>

void f() {
    int a = 1;
    static int b = 1;
    printf("Val. Automatici: %i, Var statica: %i\n", a,b);
    a = a+1;
    b = b+1; // Viene mantenuto per le successive chiamate a f()
}

int main() {

    int i = 0;
    for(i = 0; i < 10; i++) {
        f();
    }

    return 0;
}
