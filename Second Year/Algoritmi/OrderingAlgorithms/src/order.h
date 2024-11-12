#ifndef ORDER_H
#define ORDER_H
#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <time.h>
#include <math.h>
#include "linkedlist.h"


// Function to print the progress bar
void printProgressBar(int progress, int total) {
    float percentage = (float)progress / total;
    int barWidth = 100; // Width of the progress bar

    // Hashes = Progress of the algorithm
    int hashes = (int)(percentage * barWidth);

    // Move the cursor back to the beginning of the line
    printf("\r[");

    // Print the hashes
    for (int i = 0; i < hashes; i++) {
        // The ANSI escape codes for colors allow you to print text in different colors in most modern terminals. For example:
        if (percentage < 0.33) {
            printf("\033[31m#\033[0m"); // Red for 0-33%
        } else if (percentage < 0.66) {
            printf("\033[33m#\033[0m"); // Yellow for 34-66%
        } else {
            printf("\033[32m#\033[0m"); // Green for 67-100%
        }
    }

    // Print the spaces
    for (int i = hashes; i < barWidth; i++) {
        printf(" ");
    }

    // Print the percentage
    printf("] %.2f%%", percentage * 100);

    fflush(stdout); // Flush the output so it allows real time update
}


// Swaps two elements
void swap(int *a, int *b)
{
    int temp = *a;
    *a = *b;
    *b = temp;
}

/* ----------------------- HEAP -------------------------- */

void heapify(int arr[], int n, int i) {
    int largest = i;           // Initialize largest as root
    int left = 2 * i;          // Left child index
    int right = 2 * i + 1;     // Right child index

    // If left child is larger than root
    if (left < n && arr[left] > arr[largest])
        largest = left;

    // If right child is larger than largest so far
    if (right < n && arr[right] > arr[largest])
        largest = right;

    // If largest is not root
    if (largest != i) {
        swap(&arr[i], &arr[largest]);
        // Recursively heapify the affected subtree
        heapify(arr, n, largest);
    }
}

// Build a max heap from an array
void buildHeap(int* arr, int n) {
    // We start from n/2 because leafes are already in heap form
    for (int i = n / 2 - 1; i >= 0; i--)
        heapify(arr, n, i);
}

// Main function to perform heap sort
void heapSort(int arr[], int n) {
    // Build a heap
    buildHeap(arr, n);
    // Extract elements from the heap one by one
    for (int i = n - 1; i >= 0; i--) {
        swap(&arr[0], &arr[i]);
        // Call heapify on the reduced heap
        heapify(arr, i, 0);
        printProgressBar(n - i, n); // Show progress after each extraction
    }
}

/* ----------------------- INSERTION SORT -------------------------- */

/**
 * @brief Sorts all the integers in an array
 * @param The array that has to be ordered.
 */
void insertion_sort(int *a, int length)
{
    int key, j, i;
    for(i = 1; i < length; i++) {
        key = a[i];
        j = i - 1;
        while(j >= 0 && a[j] > key) {
            a[j+1] = a[j];
            j--;
        }
        a[j+1] = key;

        // Update the progress bar after each outer loop iteration
        printProgressBar(i, length - 1);
    }
}

/* ----------------------- MERGE -------------------------- */
// Function to merge two subarrays in arr[] using a single temporary array
void merge(int* arr, int left, int mid, int right, int *mergeCount, int totalMerges) {
    int size = right - left + 1;
    int b[size];

    int i = left;       // Starting index for left subarray
    int j = mid + 1;    // Starting index for right subarray
    int k = 0;          // Index for temp array

    // Merge both parts into b[]
    while (i <= mid && j <= right) {
        if (arr[i] <= arr[j]) {
            b[k++] = arr[i++];
        } else {
            b[k++] = arr[j++];
        }
    }

    while (i <= mid) {
        b[k++] = arr[i++];
    }

    while (j <= right) {
        b[k++] = arr[j++];
    }

    for (int m = 0; m < size; m++) {
        arr[left + m] = b[m];
    }

    // Update progress after each merge
    (*mergeCount)++;
    printProgressBar(*mergeCount, totalMerges);
}

// Function to calculate the total number of merges needed for progress tracking
int calculateTotalMerges(int n) {
    int total = 0;
    for (int size = 1; size < n; size *= 2) {
        total += n / size;
    }
    return total/2-1;
}

int calculateTotalPartitions(int n) {
    int total = 0;
    for (int size = 1; size < n; size *= 2) {
        total += n / size;
    }
    return (total/3)-1;
}


// Function to implement merge sort
void mergeSort(int *arr, int left, int right, int *mergeCount, int totalMerges) {
    if (left < right) {
        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid, mergeCount, totalMerges);
        mergeSort(arr, mid + 1, right, mergeCount, totalMerges);
        merge(arr, left, mid, right, mergeCount, totalMerges);
    }
}

/* ----------------------- QUICKSORT -------------------------- */

// Funzione per eseguire il partitioning e trovare il pivot
int partition(int *a, int p, int r, int* partCount, int totalPartition) {
    int pivot = a[r]; // Take the last element as pivot
    int i = (p - 1);

    for (int j = p; j <= r - 1; j++) {
        if (a[j] < pivot) {
            i++;
            swap(&a[i], &a[j]);
        }
    }
    // Riscambio il pivot nella posizione che divide le due metà rispettando
    // la proprietà: sx <= pivot <= dx
    swap(&a[i+1], &a[r]);
    (*partCount)++;
    if(*partCount <= totalPartition) printProgressBar(*partCount, totalPartition);
    return (i + 1);
}

void quickSort(int* a, int p, int r, int* partCount, int totalPartition) {
    if (p < r) {
        int pivot = partition(a, p, r, partCount, totalPartition);
        quickSort(a, p, pivot - 1, partCount, totalPartition);
        quickSort(a, pivot + 1, r, partCount, totalPartition);
    }
}

/* ----------------------- COUNTING_SORT -------------------------- */

// Where A is an array, k is the maximum value in the array, and n is the size of the array
void countingSort(int* A, int k, int n) {
    int *C = (int*)malloc(k * sizeof(int));
    int *B = (int*)malloc(n * sizeof(int));
    // Initialize the count array to zero
    for(int i = 0; i <= k; i++) {
        C[i] = 0;
    }
    // Count the occurrences of each value
    for(int j = 0; j < n; j++) {
        C[A[j]]++;
    }
    // Update the count array to store cumulative counts
    for(int i = 1; i <= k; i++) {
        C[i] += C[i - 1];
    }
    // Build the output array
    for(int j = n - 1; j >= 0; j--) {
        B[C[A[j]] - 1] = A[j]; // Place the element in B
        C[A[j]]--; // Decrement the count
        /* PROGRESS BAR */
        printProgressBar(n - j, n);
    }
    // Copy the result into the original array
    for(int i = 0; i < n; i++) {
        A[i] = B[i];
    }

    free(C);
    free(B);
}

/* ----------------------- RADIX_SORT -------------------------- */

int potenza (int base, int esponente) {
    int risultato = 1;
    for (int i = 0; i < esponente; i++) {
        risultato *= base;
    }
    return risultato;
}

int getCifraIth(int numero, int i) {
    return (int)(numero/(int)potenza(10, i))%10;
}

void insertionSortCypher(int *a, int length, int exp)
{
    int key, j, i;
    for(i = 1; i < length; i++) {
        key = a[i];
        j = i - 1;
        while(j >= 0 && getCifraIth(a[j], exp) > getCifraIth(key, exp)) {
            a[j+1] = a[j];
            j--;
        }
        a[j+1] = key;

        // Update the progress bar after each outer loop iteration
        printProgressBar(i, length - 1);
    }
}

// RadixSort that uses insertionSort as a subroutine
void radixSortInsertion(int *a, int ncifre, int size, int k) {
    for(int i = 0; i < ncifre; i++) {
        insertionSortCypher(a, size, i); // Counting sort on the i-th digit
        printf("\n");
    }
}

void countingSortCypher(int* A, int k, int n, int exp) {
    int *C = (int*)malloc(k * sizeof(int));
    int *B = (int*)malloc(n * sizeof(int));
    // Initialize the count array to zero
    for(int i = 0; i <= k; i++) {
        C[i] = 0;
    }
    // Count the occurrences of each value
    for(int j = 0; j < n; j++) {
        C[getCifraIth(A[j], exp)]++;
    }
    // Update the count array to store cumulative counts
    for(int i = 1; i <= k; i++) {
        C[i] += C[i - 1];
    }
    // Build the output array
    for(int j = n - 1; j >= 0; j--) {
        B[C[getCifraIth(A[j], exp)] - 1] = A[j]; // Place the element in B
        C[getCifraIth(A[j], exp)]--; // Decrement the count
        /* PROGRESS BAR */
        printProgressBar(n - j, n);
    }
    // Copy the result into the original array
    for(int i = 0; i < n; i++) {
        A[i] = B[i];
    }

    free(C);
    free(B);
}

void radixSortCounting(int *a, int ncifre, int size, int k) {
    for(int i = 0; i < ncifre; i++) {
        countingSortCypher(a, size, 10, i); // Counting sort on the i-th digit
        printf("\n");
    }
}

/* ----------------------- BUCKET SORT -------------------------- */


int maxValue(int *a, int size) {
    int max = *a;
    for(int i = 0; i < size; i++) {
        if(a[i] > max) max = a[i];
    }
    return max;
}


int* bucketSort(int *a, int size, int k) {
    struct node **buckets = (struct node**)malloc(k * sizeof(struct node*));
        if (!buckets) {
            printf("Errore di allocazione dei bucket!\n");
            exit(1);
        }

        // Initialize each bucket
        for (int i = 0; i < k; i++) {
            buckets[i] = NULL;
        }

        int M = maxValue(a, size); // Max value in the array

        // Distribute elements into buckets
        for (int i = 0; i < size; i++) {
            int bucketIndex = (int)floor((k * (double)a[i]) / (M + 1));  // Casting to int
            // Checks for out of range bucket indexes
            if (bucketIndex < 0 || bucketIndex >= k) {
                printf("Errore: indice del bucket fuori intervallo (%d) per a[%d] = %d\n", bucketIndex, i, a[i]);
                exit(1);
            }
            printf("Inserisco %d nel bucket %d\n", a[i], bucketIndex);
            // Inserts while ordering the elements in the bucket
            buckets[bucketIndex] = inserimentoOrdinato(buckets[bucketIndex], a[i]);
        }

        struct node* result = concatenateLists(buckets, k);

        // Free the memory of each bucket's linked list
        for (int i = 0; i < k; i++) {
            struct node* current = buckets[i];
            while (current != NULL) {
                struct node* temp = current;
                current = current->next;
                free(temp);
            }
        }

        free(buckets);

        return a;
}


/* ----------------------- FACTORIAL -------------------------- */

int factorial(int n) {
    if (n == 0) return 1;
    else return n * factorial(n-1);
}

/* ----------------------- OTHER -------------------------- */

void print_array(int *a, int n) {
    for(int i = 0; i < n; i++) printf("%d ", a[i]);
    printf("\n");
}




#endif
