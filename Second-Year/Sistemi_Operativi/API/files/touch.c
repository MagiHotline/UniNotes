#include <stdio.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>
#include <errno.h>
#include <stdlib.h>

int main(int argc, char * argv[])
{
    int ret,fd;
    if (argc == 1) {
        fprintf(stderr ,"nome file mancante \n"); exit ( -1) ;}
        fd = open(argv[1],O_RDWR);
        if(fd == -1 && errno == ENOENT) {
        // non esiste un file con quel nome
        fd = open(argv[1],O_WRONLY|O_CREAT|O_TRUNC, 0644); if(fd == -1) {
        perror("fallimento creazione del file");
        exit(-1);
        } else {
            char c;
            ret = write(fd, &c, sizeof(char));
            if(ret == -1) {
                perror("fallimento scrittura del file");
                exit(-1);
            } else if(ret == 0) {
                puts("file vuoto");
                exit(-1);
            } else {
                lseek(fd, 0, SEEK_SET);
                ret = write(fd, &c, ret);
                puts("Ho scritto");
                if(ret == -1) {
                    perror("fallimento scrittura file");
                    exit(-1);
                }
            }
        }
    }
}
