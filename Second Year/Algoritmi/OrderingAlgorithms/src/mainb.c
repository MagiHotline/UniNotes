#include "btree.h"

int main(int argc, char* argv[]) {
    btree *tree = NULL;
    tree = add(tree, 3);
    tree = add(tree, 4);
    tree = add(tree, 9);
    tree = add(tree, 1);
    print_in_order(tree); // Already ordered ✨
    return 0;
}
