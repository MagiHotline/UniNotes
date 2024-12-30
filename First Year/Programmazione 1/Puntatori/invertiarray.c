void inverti(int[], int);
void inverti2(int*, int);

#include <stdio.h>


int main() {

    int dim = 10;
    int a[dim];

    inverti(a,dim);


    return 0;
}

void inverti(int arr[], int dim) {
    int temp, i;

    for(i = 0; i < dim/2; i++) {
        temp = arr[i];
        arr[i] = arr[dim - i - 1];
        arr[dim - i - 1] = temp;
    }
}

void inverti2(int *a, int dim) {
    int temp, i;

    for(i = 0; i < dim/2; i++) {
        temp = *(a+i);
        *(a+i) = *(a + dim - i - 1);
        *(a+ dim - i - 1) = temp;
    }
}

