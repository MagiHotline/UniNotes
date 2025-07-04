#include "common.h"
#include <stdio.h>
#include <stdlib.h>
#include <stdint.h>
#include <unistd.h>
#include <string.h>
#include <fcntl.h>
#include <sys/msg.h>
#include <openssl/sha.h>

void digest_file(const char *filename, uint8_t * hash) {
    
    SHA256_CTX ctx;
    SHA256_Init(&ctx);

    char buffer[32];
    int file = open(filename, O_RDONLY, 0);
    if (file == -1) {
        printf("File %s does not exist\n", filename);
        exit(1);
    }

    ssize_t bR;
    do {
        bR = read(file, buffer, 32);
        if (bR > 0) {
            // Cast a buffer to uint8_t* for SHA256_Update
            SHA256_Update(&ctx, (uint8_t*) buffer, bR);
        } else if (bR < 0) {
            printf("Read failed\n");
            close(file);
            exit(1);
        }
    } while (bR > 0);

    SHA256_Final(hash, &ctx);
    close(file);
}

int main(int argc, char *argv[]) {

    if (argc < 3) {
        fprintf(stderr, "Usage: %s <filename> <client_pid>\n", argv[0]);
        return 1;
    }

    const char *filename = argv[1];
    pid_t client_pid = atoi(argv[2]);

    uint8_t hash[32];
    digest_file(filename, hash);

    // Convert binary hash to hex string
    struct msg_response resp;
    resp.mtype = RESP_MTYPE + client_pid;
    for (int i = 0; i < 32; i++) {
        sprintf(resp.hash + i * 2, "%02x", hash[i]);
    }

    resp.hash[64] = '\0';

    // Get the message queue
    int msgid = msgget(MSG_KEY, 0666);
    if (msgid == -1) {
        perror("msgget");
        return 1;
    }

    // Send the response back to the client
    if (msgsnd(msgid, &resp, sizeof(resp.hash), 0) == -1) {
        perror("msgsnd");
        return 1;
    }

    return 0;
}
