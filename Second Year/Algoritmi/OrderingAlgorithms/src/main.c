/*
 * File: main.c
 * Description: Executes various type of sorting algorithms based on a user input (unsigned long long).
 * Author: Paolo Imbriani, @magihotline on github
 * Date: 2024-11-13
 * License: MIT License
 */
#include <stdio.h>
#include <stdlib.h>
#include <SDL.h>
#include <sys/time.h>
#include "order.h"
#define WIDTH_SCREEN 800
#define HEIGHT_SCREEN 600

void initVideo(SDL_Window *window, SDL_Renderer *renderer) {
    // Initialize SDL
    if (SDL_Init(SDL_INIT_VIDEO) != 0) {
        printf("Error initializing SDL: %s\n", SDL_GetError());
        exit(-1);
    }

    // Create a window
    window = SDL_CreateWindow(
        "Sorting Visualization",
        SDL_WINDOWPOS_CENTERED,
        SDL_WINDOWPOS_CENTERED,
        WIDTH_SCREEN,
        HEIGHT_SCREEN,
        SDL_WINDOW_SHOWN
    );

    // Check if the window was successfully created
    if (!window) {
        printf("Error creating window: %s\n", SDL_GetError());
        SDL_Quit();
        exit(-1);
    }

    renderer = SDL_CreateRenderer(window, -1, SDL_RENDERER_ACCELERATED);

    if (!renderer) {
        printf("Error creating renderer: %s\n", SDL_GetError());
        SDL_DestroyWindow(window);
        SDL_Quit();
        exit(-1);
    }
}


int main(int argc, char* argv[]) {

    SDL_Window *window = NULL;
    SDL_Renderer *renderer = NULL;

    initVideo(window, renderer);
    // Set the draw color (RGBA)
    SDL_SetRenderDrawColor(renderer, 255, 0, 0, 255);  // Red color


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

    printf( "\n1. Insertion Sort O(n^2)"
            "\n2. Merge Sort O(n log n)\n"
            "3. HeapSort O(n log n)\n"
            "4. Fattoriale\n"
            "5. Quicksort O(n log n)\n"
            "6. Counting Sort O(n+k)\n"
            "7. Radix Sort O(d(n+k))\n"
            "8. Bucket Sort\n"
            "9. Generic Bubble Sort O(n^2)"
            "\nPremi qualsiasi altro numero per uscire."
            "\nScegli l'algoritmo che vuoi usare: "
    );

    scanf("%d",&option);
    // Start the clock
    start = clock();
    switch (option) {
        case 1: {
            //insertion_sort(array, n);
            genericInsertionSort(array, n, sizeof(int), intCompare);
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
        case 9: {
            genericBubbleSort(array, n, sizeof(int), intCompare);
            break;
        }
        default: {
            printf("Uscito senza ordinare\n");
            free(head);
            free(array);
            exit(1);
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

    // CLEAN UP
    free(head);
    free(array);
    // Destroy the renderer and window
    SDL_DestroyRenderer(renderer);
    SDL_DestroyWindow(window);
    SDL_Quit();

    return 0;
}
