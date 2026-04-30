/*
 * File: stack.c
 * Description: Implementation of a stack data structure
 * Author: Paolo Imbriani, @magihotline on github
 * Date: 2024-11-13
 * License: MIT License
 */
#include <stdio.h>
#include <stdlib.h>

typedef struct stack
{
    int val;
    stack* next;
}stack;

stack* push(stack* top, int val)
{
    // Alloco spazio per il nuovo elemento
    stack* new_top = (stack*)malloc(sizeof(stack));

    if(top != NULL) {
        new_top->val = val;
        new_top->next = top;
        top = new_top;
    } else {
        printf("Memoria esaurita");
    }

    return new_top;
}

stack* pop(stack* top)
{
    if(top != NULL) {
        stack* temp = top;
        top = top->next;
        free(temp);
    } else {
        printf("Stack vuoto");
    }

    return top;
}
