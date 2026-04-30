/*
 * File: btree.h
 * Description: Implements a simple binary search tree
 * Author: Paolo Imbriani, @magihotline on github
 * Date: 2024-11-13
 * License: MIT License
 */

#include <stdio.h>
#include <stdlib.h>

typedef enum color {
    RED,
    BLACK
}color;

// Albero Binario di Ricerca
typedef struct rbtree {
    int item;
    color color;
    struct rbtree *left;
    struct rbtree *right;
}rbtree;

/**
* @brief Creates a new node with the item passed in as an argument and pointers to the left and right nodes
* @param int item - the item to create a new node with
* Return: btree * - the new node created
*/
rbtree *create_node(int item, color color) {
    // Allocate memory for the new node
    rbtree *new_btree = (rbtree*)malloc(sizeof(rbtree));
    // Set the item of the new node to the item passed in as an argument
    new_btree->item = item;
    color = BLACK;
    new_btree->left = NULL;
    new_btree->right = NULL;

    // Return the new node
    return new_btree;
}

/**
* @brief Adds an item to the binary tree
* @param btree *bt - the binary tree to add the item to
* @param int item - the item to add to the binary tree
* @return btree * - the binary tree with the new item added
*/
rbtree *add(rbtree *bt, int item) {
    // If the btree is empty create a new node
    if(bt == NULL) {
        bt = create_node(item, BLACK);
    } else if(bt->item > item) {
        // if the item is less than the current node, go to the left
        bt->left = add(bt->left, item);
    } else {
        // if the item is greater than the current node, go to the right
        bt->right = add(bt->right, item);
    }

    return bt;
}

/**
* @brief Prints the binary tree in order
* @param btree *bt - the binary tree to print in order
*/
void print_in_order(rbtree *bt) {
    // Recursively print the left node, then the current node, then the right node
    if(bt != NULL) {
        print_in_order(bt->left);
        printf("%d\n", bt->item);
        print_in_order(bt->right);
    }
}

/**
* @brief Search an item inside the binary search tree.
* @param btree *bt - the binary tree to search into
* @param int k - the item to search
* @return int - 1 if the item is found, 0 otherwise
*/
int search(rbtree *bt, int k) {
    if(bt != NULL) {
        if(k == bt->item) {
            return 1;
        } else if(k < bt->item) {
            return search(bt->left, k);  // return the result of searching in the left subtree
        } else {
            return search(bt->right, k); // return the result of searching in the right subtree
        }
    }
    return 0;
}

int extract(rbtree *bt, int k) {
    if(bt != NULL) {
        if(k == bt->item) {
            return bt->item;
        } else if(k < bt->item) {
            return search(bt->left, k);  // return the result of searching in the left subtree
        } else {
            return search(bt->right, k); // return the result of searching in the right subtree
        }
    }
    return -1;
}
