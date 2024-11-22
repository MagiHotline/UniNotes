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

    DIR* dir;
    struct dirent *stdir;
    struct stat statbuf;
    char *path;
    char filename[600];

    switch(argc) {
        case 1: {
            path = ".";
            break;
        }
        case 2:
        {
            path = argv[1];
            break;
        }
        default: {
            fprintf(stderr, "Troppi argomenti!");
            exit(-1);
        }
    }

   if((dir = opendir(path)) == NULL) {
       perror("Errore di scrittura");
       exit(-1);
   }

   printf("Cammino: %s", path);
   while((stdir = readdir(dir)) != NULL) {
       sprintf(filename, "%s%s", path, stdir->d_name);
       if(stat(filename, &statbuf) == -1) {
           perror("Errore della stat");
           exit(-1);
       }
   }

    // Check if the file is a regular file or a directory
    if (S_ISREG(statbuf.st_mode))
        printf("[r] %10lld %s \n", statbuf.st_size, stdir->d_name);
    else if(S_ISDIR(statbuf.st_mode))
        printf("[d] %10lld %s \n",statbuf.st_size, stdir->d_name); // If is a directory
    else printf("[ ] %10lld %s \n", statbuf.st_size, stdir->d_name); // IF

    closedir(dir);
    return 0;
}
