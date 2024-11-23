#include <dirent.h>
#include <errno.h>
#include <stdio.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <string.h>
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
            // takes the directory where the program is running
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
            exit(0);
        }
    }

    // Get the stats of the path that was passed as argument (it can be either a file or a directory)
    if(stat(path, &statbuf) == -1) {
        perror("Errore della stat del file");
        exit(-1);
    }

    // Check if its not a directory
    if(!S_ISDIR(statbuf.st_mode)) {
        printf("[r] %5lld %s %s", statbuf.st_size, path, ctime(&(statbuf.st_mtime)));
        exit(1); // Exit the program
    }

    // Open the directory
    if((dir = opendir(path)) == NULL) {
        perror("Errore di apertura");
        exit(-1);
    } else {
        printf("[d] %5lld %s %s", statbuf.st_size, path, ctime(&(statbuf.st_mtime)));
    }

    printf("Path: %s\n", path);
    while((stdir = readdir(dir)) != NULL) {
        // Print the name of the file
        // Takes the path that has the format of "path/filename"
        snprintf(filename, sizeof(filename), "%s/%s", path, stdir->d_name);
        // Check if extraction of the file status is successful
        if(stat(filename, &statbuf) == -1) {
            perror("Errore della stat");
            exit(-1);
        }

        // Remove the newline character at the end of the string
        char *c_time_string = ctime(&(statbuf.st_mtime));
        size_t len = strlen(c_time_string);
        if (len > 0 && c_time_string[len - 1] == '\n') {
            c_time_string[len - 1] = '\0';
        }

        if(S_ISREG(statbuf.st_mode)) {
            printf("[r] %10lld %s %s\n", statbuf.st_size, c_time_string, stdir->d_name);
        } else if(S_ISDIR(statbuf.st_mode)) {
            printf("[d] %10lld %s %s\n", statbuf.st_size, c_time_string, stdir->d_name);
        } else {
            printf("[other] %10lld %s %s\n", statbuf.st_size, c_time_string, stdir->d_name);
        }
    }

    closedir(dir);
    exit(0);
}
