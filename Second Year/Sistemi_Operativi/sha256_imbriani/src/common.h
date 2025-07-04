#ifndef COMMON_H
#define COMMON_H

#include <unistd.h>
#include <stddef.h>

#define SHM_KEY 0x1234 // key for shared memory
#define MSG_KEY 0x5678 // key for message queue
#define SEM_KEY 0x1111 // key for semaphore

#define MAX_FILE_SIZE 4096 // Maximum size of the file to hash
#define MAX_CONCURRENT 5 // Maximum number of concurrent file hashes
#define CTRL_MTYPE 99 // Control message type for changing the limit of concurrent files
#define REQ_MTYPE 1 // Request message type for client to server communication
#define RESP_MTYPE 2 // Response message type for server to client communication

// Messaggio che invia il client al server
struct msg_request {
    long mtype;
    size_t size;
    pid_t pid;
};

// Messaggio che il server invia al client
struct msg_response {
    long mtype;
    char hash[65];
};

// Messaggio che permette di modificare il limite di file concorrenti
struct msg_control {
    long mtype;
    int new_limit;
};

#endif
