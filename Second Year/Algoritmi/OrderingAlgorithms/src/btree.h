#include <stdio.h>
#include <stdlib.h>

// Albero Binario di Ricerca
typedef struct btree {
    int item;
    struct btree *left;
    struct btree *right;
}btree;

/*
* Creates a new node with the item passed in as an argument and pointers to the left and right nodes
* @param int item - the item to create a new node with
* @return btree * - the new node created
*/
btree *create_node(int item) {
    // Allocate memory for the new node
    btree *new_btree = (btree*)malloc(sizeof(btree));
    // Set the item of the new node to the item passed in as an argument
    new_btree->item = item;
    new_btree->left = NULL;
    new_btree->right = NULL;

    // Return the new node
    return new_btree;
}

/*
* Adds an item to the binary tree
* @param btree *bt - the binary tree to add the item to
* @param int item - the item to add to the binary tree
* @return btree * - the binary tree with the new item added
*/
btree *add(btree *bt, int item) {
    // If the btree is empty create a new node
    if(bt == NULL) {
        bt = create_node(item);
    } else if(bt->item > item) {
        // if the item is less than the current node, go to the left
        bt->left = add(bt->left, item);
    } else {
        // if the item is greater than the current node, go to the right
        bt->right = add(bt->right, item);
    }

    return bt;
}

/*
* Prints the binary tree in order
* @param btree *bt - the binary tree to print in order
*/
void print_in_order(btree *bt) {
    // Recursively print the left node, then the current node, then the right node
    if(bt != NULL) {
        print_in_order(bt->left);
        printf("%d\n", bt->item);
        print_in_order(bt->right);
    }
}

/*
* Search an item inside the binary search tree.
* @param btree *bt - the binary tree to search into
* @param int k - the item to search
* @return int - 1 if the item is found, 0 otherwise
*/
int search(btree *bt, int k) {
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

int extract(btree *bt, int k) {
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
