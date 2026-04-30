#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>


int main(int argc, char* argv[]) {
    // Open file1.txt in read-only mode and create it if it doesn't exist
    int fd = open(argv[1], O_RDONLY);
    if (fd == -1) {
        perror("Error opening first file");
        exit(1);
    }

    // Check if file is regular
    struct stat *statbuf;
    int ret = stat(argv[1], statbuf);
    if(!S_ISREG(statbuf->st_mode)) {
        perror("File non regolare");
        exit(-1);
    }

    // Open file2.txt in write-only mode, create if it doesn't exist, and truncate (if file exists viene troncato a 0 bytes)
    int fd2 = open(argv[2], O_WRONLY | O_CREAT | O_TRUNC, 0666);
    if (fd2 == -1) {
        perror("Error opening the second file");
        close(fd);
        exit(1);
    }

    if(argc == 3) {
        ssize_t dim = 1024; // Buffer size
        ssize_t letti; // Number of bytes read
        char buf[dim];

        // Read from file1.txt and write to file2.txt
        while ((letti = read(fd, buf, dim)) > 0) {
            if (write(fd2, buf, letti) != letti) {
                perror("Write error");
                close(fd);
                close(fd2);
                exit(1);
            }
        }

        // Check if read failed
        if (letti < 0) {
            perror("Read error");
        }
    } else {
        perror("Not enough arguments");
        close(fd);
        close(fd2);
        exit(-1);
    }

    // Close file descriptors
    close(fd);
    close(fd2);
    exit(0);
}
