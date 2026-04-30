#include <stdio.h>

#define DIM 10
int main() {
    //Leggermente più efficiente del naive sort
    //Complessità Computazionale BEST CASE: O(n), Worst Case: O(n^2)
    int array[DIM] =  {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    int ord = 0;
    int nConfronti = 0;
    for(int i = 0; i < DIM && ord == 0; i++) {
        ord = 1;
        for(int j = 0; j < DIM-1; j++) {
            if(array[j] > array[j+1])  {
                int temp = array[j];
                array[j] = array[j+1];
                array[j+1] = temp;
                ord = 0;
                nConfronti++;
            } 
        }      
    }

    for(int i = 0; i < DIM; i++) {
        printf("%d ", array[i]);
    }
    
    printf("Numero confronti totali: %d", nConfronti);

    return 0;
}