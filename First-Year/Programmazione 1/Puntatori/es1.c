//Dato un array usiamo 2 puntatori per indicare le componenti con valore minimo e massimo;

#include <stdio.h>
#define N 10

void swap(int *a, int *b) {
    int temp;
    temp = *a;
    *a = *b;
    *b = temp;
}



int main() {

    int a[N];
    int *min = NULL;
    int *max = NULL;

    min = &a[0];
    max = &a[0];

    for(int i = 0; i < N; i++) {
        if(a[i] < *min) min = &a[i];
        if(a[i] > *max) max = &a[i];
    }


    return 0;

}
