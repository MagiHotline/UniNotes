//Funzione ricorsiva che calcola il massimo di un vettore di un array di interi
//con procedimento ricorsivo
#include <stdio.h>

int max(int *v, int dim) {
    int massimo = *v;
    if(dim == 1) {
        return v[0];
    } else {
        if(*v > massimo) {
            return *v;
        } else {
            return massimo;
        }
        return max(v+1, dim-1);
    }
}

//SOLUZIONE PROF

int maxRic(int *array, int dim) {

    int max;
    if(dim == 1) {
        return array[0];
    } else {
        max = maxRic(&array[1], dim-1);
        if(array[0] > max) {
            return array[0];
        } else {
            return max;
        }   
    }

}


int main() {

    int v[] = {1, 4, 6, 7, 2};

    printf("%d\n", max(v, 5));


    return 0;
}