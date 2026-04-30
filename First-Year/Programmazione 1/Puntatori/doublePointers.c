#include <stdio.h>

int main() {

    typedef int* intptr; //Puntatore ad un intero
    typedef intptr* int2ptr; //Puntatore ad un puntatore ad intero


    int c,d;

    intptr p1, p2;
    int2ptr pp1, pp2;

    c = 54, d = 10; 

    p1 = &c;
    p2 = &c;

    printf("%d %d %d %d", c, d, *p1, *p2); //54 10 54 54

    p1 = &d;

    *p1 = *p1 + *p2; //10 + 54 = 64

    printf("%d %d %d %d", c, d, *p1, *p2); //54 64 64 54

    pp1 = &p1;
    pp2 = &p2;
    *pp2 = *pp1; //&d

    printf("%d %d %d %d", c, d, *p1, *p2); //54 64 64 54


    return 0;
}