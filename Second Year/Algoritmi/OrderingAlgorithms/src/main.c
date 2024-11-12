#include <stdio.h>
#include <stdlib.h>
#include <sys/time.h>
#include "order.h"

int main(int argc, char* argv[]) {

    // Setting the seed for the random number generator
    srand(time(NULL));
    // Variables for the clock
    clock_t start, end;
    double cpu_time_used;
    // Input
    unsigned long long n;
    int option;

    printf("Inserisci input: ");
    scanf("%llu", &n);
    // Array of n elements
    int* array = (int*)malloc(n * sizeof(int));
    struct node* head = NULL;
    int k = 100000;
    // Fill the array with random numbers
    for(int i = 0; i < n; i++) {
        array[i] = rand()%k + 1;
    }

    printf("\n1. Insertion Sort\n2. Merge Sort\n3. HeapSort\n4. Fattoriale\n5. Quicksort\n6. Counting Sort\n7. Radix Sort\n8. Bucket Sort\n Premi qualsiasi altro numero per uscire.\nScegli l'algoritmo che vuoi usare: ");
    scanf("%d",&option);
    // Start the clock
    start = clock();
    switch (option) {
        case 1: {
            insertion_sort(array, n);
            break;
        }
        case 2: {
            int mergeCount = 0;
            // Calculate the total number of merges
            int totalMerges = calculateTotalMerges(n);
            mergeSort(array, 0, n-1, &mergeCount, totalMerges);
            break;
        }
        case 3: {
            heapSort(array, n);
            break;
        }
        case 4: {
            // 64 bit
            unsigned long long result = factorial(n);
            printf("Il fattoriale di %llu e': %llu", n, result);
            break;
        }
        case 5:
        {
            int partitionCount = 0;
            int totalMerges = calculateTotalPartitions(n);
            quickSort(array, 0, n-1, &partitionCount, totalMerges);
            break;
        }
        case 6:
        {
            countingSort(array, k, n);
            break;
        }
        case 7:
        {
            radixSortInsertion(array, 6, n, k);
            break;
        }
        case 8: {
            array = bucketSort(array, n, n);
            break;
        }
        default: {
            printf("Uscito senza ordinare");
            break;
        }
    }
    // End of clock
    end = clock();

    cpu_time_used = ((double)(end - start)) / CLOCKS_PER_SEC;

    // Convert to milliseconds
    double time_in_ms = cpu_time_used * 1000;

    if(time_in_ms < 1) {
        printf("\nfinished in %fµs", time_in_ms*100);
    } else if (time_in_ms > 1000) {
        printf("\nfinished in %fs", time_in_ms/1000);
    }
    else {
        printf("\nfinished in %fms", time_in_ms);
    }

    // PRINTING THE ARRAY
    char trash; scanf("%c", &trash);
    char printArray;
    printf("\nVuoi stampare il risultato? [y/n] ");
    scanf("%c", &printArray);

    if(printArray == 'y')
        print_array(array, n);

    free(head);
    free(array);

    return 0;
}
