#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/msg.h>
#include <sys/ipc.h>
#include <sys/shm.h>
#include <sys/sem.h>
#include <sys/wait.h>
#include <unistd.h>
#include <openssl/sha.h>
#include "common.h"

int active_processes = 0; // risorsa condivisa per contare i processi attivi
int max_processes = MAX_CONCURRENT;

// Coda per le richieste
struct msg_request request_queue[100];
int queue_size = 0;

// Semaforo per proteggere contatore processi
int sem_id;

void sem_wait() {
    // (Decrementa il semaforo)
    struct sembuf op = {0, -1, 0};
    semop(sem_id, &op, 1); // semop() performs operations on selected semaphores in the set
}

void sem_signal() {
    // (Incrementa il semaforo)
    struct sembuf op = {0, +1, 0};
    semop(sem_id, &op, 1); // semaphore operation
}

// Priorità: ordina la coda per dimensione
void enqueue(struct msg_request req) {
    request_queue[queue_size++] = req;
    for (int i = queue_size - 1; i > 0; i--) {
        // Se la richiesta corrente è più grande della precedente, scambiale
        if (request_queue[i].size > request_queue[i - 1].size) {
            struct msg_request tmp = request_queue[i];
            request_queue[i] = request_queue[i - 1];
            request_queue[i - 1] = tmp;
        }
    }
}

// Rimuove l'ultima richiesta dalla coda e la restituisce
struct msg_request dequeue() {
    queue_size--;
    return request_queue[queue_size]; 
}

// Processo per spawnare un worker
void spawn_worker(struct msg_request req) {
    pid_t pid = fork();
    if (pid == 0) {
        // figlio
        char id_buf[32];
        char worker_pid_buf[32];
        snprintf(worker_pid_buf, sizeof(worker_pid_buf), "%d", getpid());
        snprintf(id_buf, sizeof(id_buf), "%d", req.pid);
        
        // Esegui il worker con i parametri necessari
        execl("./worker", "worker", id_buf, worker_pid_buf, NULL);
        perror("execl failed");
        exit(1);
    } else {
        sem_wait(); // Ci assicuriamo che il contatore dei processi sia protetto
        active_processes++; 
        sem_signal();
    }
}

// Gestore del segnale SIGCHLD per gestire la terminazione dei processi figli
void sigchld_handler(int signum) {
    wait(NULL);
    sem_wait(); // Proteggiamo l'accesso alla risorsa condivisa
    active_processes--;
    sem_signal();
}

int main() {
    // SIGCHILD : to parent on child stop or exit
    signal(SIGCHLD, sigchld_handler);

    // 
    int msgid = msgget(MSG_KEY, IPC_CREAT | 0666);
    sem_id = semget(SEM_KEY, 1, IPC_CREAT | 0666);
    semctl(sem_id, 0, SETVAL, 1);

    printf("Server avviato\n");

    while (1) {
        // Controlla se ci sono richieste in coda e controllo il tipo di richiesta
        struct msg_request req;
        if (msgrcv(msgid, &req, sizeof(req) - sizeof(long), 0, IPC_NOWAIT) != -1) {
            // Se il tipo di messaggio è una REQ_MTYPE, lo mettiamo in coda
            if (req.mtype == REQ_MTYPE) {
                enqueue(req);
            } else if (req.mtype == CTRL_MTYPE) {
                // Se invece è un messaggio di controllo, aggiorniamo il limite dei processi
                max_processes = req.size;
                printf("Nuovo limite processi: %d\n", max_processes);
            }
        }

        // se la coda non è vuota e possiamo spawnare un nuovo worker
        if (queue_size > 0) {
            sem_wait(); // Proteggiamo l'accesso alla risorsa condivisa
            int can_spawn = (active_processes < max_processes);
            sem_signal();
            if (can_spawn) {
                struct msg_request next = dequeue();
                spawn_worker(next);
            }
        }
    }

    return 0;
}
