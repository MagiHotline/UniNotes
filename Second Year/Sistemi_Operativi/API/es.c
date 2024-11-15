#include <errno.h>
#include <stdlib.h>
#include <stdio.h>
#include <string.h>

int main(int argc, char *argv[]) {

    // gli passo una stringa "esempio PATH" se questa stringa corrisponde alla variabile d'ambient'
    extern char **environ;
    int i;
    int found = 0;
    if (argc != 1) {
        for(i=0; environ[i]!=NULL; i++) {
            if (strncmp(environ[i], argv[1], strlen(argv[1])) == 0) {
                 printf("%s\n", strstr(environ[i], argv[1]));
                 found = 1;
                 break;
            }
        }

        if (!found) {
            printf("%s not found\n", argv[1]);
            exit(-1);
        }
    }

    exit(0);
}
