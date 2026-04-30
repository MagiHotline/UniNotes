#include <errno.h>
#include <stdlib.h>
#include <stdio.h>
#include <string.h>

int main(int argc, char *argv[]) {

    // gli passo una stringa "esempio PATH" se questa stringa corrisponde alla variabile d'ambient'
    extern char **environ;
    int i;
    if (argc == 1) {
        for(i=0; environ[i]!=NULL; i++) {
            printf("%s\n", environ[i]);
        }
    }

    exit(0);
}
