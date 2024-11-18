#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <string.h>
#include <fcntl.h>


int main(int argc, char* argv[]) {
    char *tmplt = "#include <stdio.h>\n#include <stdlib.h>\n\nint main(int argc, char* argv[]) { \n return 0; \n}";
    int ret, fd;
    if(argc == 1) {
        // If pass only one argument then the filename was not inserted
        fprintf(stderr, "Non è stato inserito il nome del file");
        exit(-1);
    } else {
        // Open the file in write-only mode, create if it doesn't exist, and truncate (if file exists viene troncato a 0 bytes)
        fd = open(argv[1], O_WRONLY | O_CREAT | O_TRUNC, 0666);
        if(fd == -1) {
            perror("Errore nell'apertura del file");
            exit(-1);
        }

        // Write the template into the file
        ret = write(fd, tmplt, strlen(tmplt));
        if(ret == -1) {
            perror("Errore nella scrittura del file");
            close(fd);
            exit(-1);
        }
        close(fd);
    }
}
