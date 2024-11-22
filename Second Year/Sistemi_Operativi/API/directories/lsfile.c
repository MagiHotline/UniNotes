#include <dirent.h>
#include <errno.h>
#include <stdio.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>
#include <stdlib.h>
#include <time.h>

int main(int argc, char* argv[]) {

    struct dirent *stdir;
    struct stat statbuf;
    char* path;
    char filename[512];

    switch(argc) {
        case 1: {
            path = ".";
            break;
        }
        case 2: {
            path = argv[1];
            break;
        }
        default: {
            fprintf(stderr, "Usage: %s [path]\n", argv[0]);
            exit(0);
        }
    }

    // Check if extraction of the file status is successful
    if(stat(path, &statbuf) == -1) {
        perror("errore della stat");
        exit(-1);
    }

    // Check if the file is a regular file or a directory
    if (S_ISREG(statbuf.st_mode))
        printf("[r] %10lld %s %s \n", statbuf.st_size, path, ctime(&(statbuf.st_mtime)));
    else if(S_ISDIR(statbuf.st_mode))
        printf("[d] %10lld %s \n",statbuf.st_size, path); // If is a directory
    else printf("[ ] %10lld %s %s \n", statbuf.st_size, path ,ctime(&(statbuf.st_mtime))); // IF

    return 0;
}
