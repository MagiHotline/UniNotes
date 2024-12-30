//Scrivere un sottoprogramma che calcola l'area e il perimetro di un cerchio,
//di raggio dato dall'utente.
//Scrivere un programma C che chiede all'utente il valore del raggio e stampa l'area
//e il perimetro del cerchio;

#include <stdio.h>

#define PI 3.141592653589
void cerchio (float, float*, float*);

int main() {

    float raggio, area, perimetro;
    scanf("%f", &raggio);
    cerchio(raggio, &area, &perimetro);

    printf("Perimetro: %f\n", perimetro);
    printf("Area: %f\n", area);

    return 0;
}

void cerchio(float r, float* p, float* a)  {

    *p = (2*PI)*r;
    *a = (r*r)*PI;

}
