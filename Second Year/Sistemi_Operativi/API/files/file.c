#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>


int main(int argc, char* argv[]) {
    // Open file1.txt in read-only mode and create it if it doesn't exist
    int fd = open("file.txt", O_RDONLY);
    if (fd == -1) {
        perror("Error opening file.txt");
        exit(1);
    }

    // Open file2.txt in write-only mode, create if it doesn't exist, and truncate (if file exists viene troncato a 0 bytes)
    int fd2 = open("file2.txt", O_WRONLY | O_CREAT | O_TRUNC, 0666);
    if (fd2 == -1) {
        perror("Error opening file2.txt");
        close(fd);
        exit(1);
    }

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

    // Close file descriptors
    close(fd);
    close(fd2);

    return 0;
}
