#ifndef _SEMAPHORE_HH
#define _SEMAPHORE_HH

// definition of the union semun
#include <sys/sem.h>

/*
errsemOpExit is a support function to manipulate a sempahore's value
of a semaphore set. Semid is a semaphore set identifier, sem_num is the index opf a semaphore in the set
sem_op is the operation performed on sem_num
*/
void semOp(int semid, unsigned short sem_num, short sem_op);

#endif
