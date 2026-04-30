#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <string.h>
#include <fcntl.h>


int main(int argc, char* argv[]) {

    struct stat buf;
    if(argc == 1) {
        fprintf(stderr, "ERRORE: Non è stato inserito il nome del file\n");
        exit(-1);
    } else {
        int ret = stat(argv[1], &buf);
        if(ret == -1) {
            perror("Error in stat");
            exit(1);
        }
        printf("Device: %d\n", buf.st_dev);
        printf("Type of device: %d\n", buf.st_rdev);
        printf("ID: %d\n", buf.st_uid); printf("Group ID: %d\n", buf.st_gid);
        printf("File type: %d\n", buf.st_mode);
        printf("Blocks allocated: %lld\n", buf.st_blocks);
        printf("Time last modification: %ld\n", buf.st_mtimespec.tv_sec);
        printf("Last access: %ld\n", buf.st_atimespec.tv_nsec);
        printf("Last status change: %ld\n", buf.st_ctimespec.tv_nsec);
        printf("File size: %lld byte\n", buf.st_size);
    }



    return 0;
}
