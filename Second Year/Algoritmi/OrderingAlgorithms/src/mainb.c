
#include "btree.h"
#include <stdlib.h>
#include <time.h>

int main(int argc, char* argv[]) {
    btree *tree = NULL;
    srand(time(NULL));
    for(int i = 0; i < 1000000; i++) {
        tree = add(tree, (rand() % 10000)+ 1);
    }

    print_in_order(tree); // Already ordered ✨

    int item;
    printf("What item you want to find? "); scanf("%d", &item);

    if(search(tree, item)) {
        printf("Found %d\n", item);
    } else {
        printf("Not found %d\n", item);
    }
    return 0;
}
