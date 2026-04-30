#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/wait.h>

int main(int argc, char* argv[]) {

     // 2 -> (2 -> 2)
    fork();
    printf("Sono fork=%d figlio di PID=%d\n", getpid(), getppid());
    fork();
    printf("Sono fork=%d figlio di PID=%d\n", getpid(), getppid());
    while(1);
}
