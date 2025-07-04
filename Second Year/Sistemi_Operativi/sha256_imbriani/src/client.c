#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/msg.h>
#include <sys/ipc.h>
#include <sys/shm.h>
#include <unistd.h>
#include "common.h"

int main(int argc, char *argv[]) {

    // take the file as an argument
    if (argc < 2) {
        printf("Uso: %s <file>\n", argv[0]);
        return 1;
    }

    // Open the file
    FILE *fp = fopen(argv[1], "rb");
    if (!fp) {
        perror("fopen");
        return 1;
    }

    // Read the file into a buffer
    char buffer[MAX_FILE_SIZE];
    size_t bytes = fread(buffer, 1, MAX_FILE_SIZE, fp);
    fclose(fp);

    // The shmat() function attaches the shared memory segment associated with the 
    // shared memory identifier, shmid, to the address space of the calling process.
    int shmid = shmget(SHM_KEY, MAX_FILE_SIZE, 0666);
    if (shmid == -1) {
        perror("shmget");
        return 1;
    }

    // Write in the shared memory
    char *shared_data = (char *) shmat(shmid, NULL, 0);
    if (shared_data == (char *) -1) {
        perror("shmat");
        return 1;
    }

    // Copy the file data to shared memory
    memcpy(shared_data, buffer, bytes);
    shmdt(shared_data); // Detach the shared memory segment, il contrario di shmat

    // Get the message queue
    int msqid = msgget(MSG_KEY, 0666);
    if (msqid == -1) {
        perror("msgget");
        return 1;
    }

    // Prepare the request message
    struct msg_request req;
    req.mtype = 1; 
    req.size = bytes;

    // Send the request with only the payload (file size and PID)
    if (msgsnd(msqid, &req, sizeof(req) - sizeof(long), 0) == -1) {
        perror("msgsnd");
        return 1;
    }

    // Attendi risposta
    struct msg_response resp;
    if (msgrcv(msqid, &resp, sizeof(resp.hash), 2, 0) == -1) {
        perror("msgrcv");
        return 1;
    }

    printf("SHA-256: %s\n", resp.hash);
    return 0;
}
