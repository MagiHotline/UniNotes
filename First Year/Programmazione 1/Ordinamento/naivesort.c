#include <stdio.h>

#define DIM 4
int main() {

    //Complessità Computazionale \frac{n*(n-1)}{2} ovvero O(n^2)

    int array[DIM] =  {9, 2, 1, 4};
    //int min;
    for(int i = 0; i < DIM-1; i++) {
        
        for(int j = i+1; j < DIM; j++) {
            if(array[j] < array[i]) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }    
    }

    for(int i = 0; i < DIM; i++) {
        printf("%d ", array[i]);
    }

    return 0;
}