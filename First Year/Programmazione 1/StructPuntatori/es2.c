//scrivere un programma c con sottoprogrammi per la gestione di voli aerei.
//volo aereo == struttura
//   codice -> stringa MAX 5 caratteri
//   partenza -> stringa MAX 20 caratteri
//   arrivo -> stringa MAX 20 caratteri
//   numero posti disponibili per ciascun giorno dell'anno -> array di int lungo 365
//vogliamo gestire al massimo 50 voli -> array di struct MAX 50 voli
#include <stdio.h>

#define MAXCOD 5
#define MAXNOME 20
#define MAXGIORNI 365
#define MAXVOLI 50

typedef struct{

    char cod[MAXCOD+1]; //+1 per rappresentare lo \0
    char part[MAXNOME+1];
    char dest[MAXNOME+1];
    int postiLiberi[MAXGIORNI];
    float costo;
    int maxPasseggeri;

} volo_t;

typedef struct {
    volo_t volo[MAXVOLI]; //-> Gestire un numero variabile di voli fino a un max di 50
    int numeroVoli;
} voli_t;


//0 - inserimento di un nuovo volo
void inserisciVolo(voli_t*);
//1 - visualizzare tutti i voli
void visualizzaVoli(voli_t *voli);
//2 - prenotare un volo specificando il codice ed il giorno
void prenotaVolo(voli_t *voli);
//3 - visualizzare il numero di posti disponibili per un volo specificando il codice del volo e il giorno
void visualizzaPostiLiberi(voli_t *voli);
//4 - cancellare un volo in base al codice
void cancellaVolo(voli_t *voli);
//5 - mostrate tutti i voli che collegano due città
void mostraVoli(voli_t *voli);
//6 - Uscire dal programma
void MostraMenu();

int main() {
    
    voli_t voli; //-> Contiene un array di voli t + il numero di voli inseriti

    int scelta;
    voli.numeroVoli = 0;

    do {

        mostraMenu();
        scanf("%d", &scelta);

        switch(scelta) {
            case 0: {
                inserisciVolo(&voli);
                break;
            }
            case 1: {
                visualizzaVoli(&voli);
                break;
            }   
            case 2: {
                prenotaVoli(&voli);
                break;
            }
            case 3: {
                visualizzaPostiLiberi(&voli);
                break;
            }
            case 4: {
                cancellaVolo(&voli);
                break;
            }
            case 5: {
                mostraVoli(&voli);
                break;
            }
            default: {
                printf("Scelta errata\n");
            }
        }
        
    }while(scelta != 6);


    return 0;
}

void MostraMenu() {

    printf("\n//0 - inserimento di un nuovo volo\n //1 - visualizzare tutti i voli\n//2 - prenotare un volo specificando il codice ed il giorno\n//3 - visualizzare il numero di posti disponibili per un volo specificando\n//5 - mostrate tutti i voli che collegano due città\n//6 - Uscire dal programma\n");

}

void inserisciVolo(voli_t *voli) {

    //Verificare se c'è spazio nell'array
    int ok = 1;
    if(voli->numeroVoli < MAXVOLI) {
        //Chiedere all'utente i parametri del volo
        //Codice
        do {
        printf("Inserisci codice: ");
        
        scanf("%s", voli->volo[voli->numeroVoli].cod);
        //Controlliamo se il codice è già stato inserito
            for(int i = 0, ok = 1; i < voli->numeroVoli && ok; i++) {
                if(strcmp(voli->volo[i].cod, voli->volo[voli->numeroVoli].cod) == 0) {
                    ok = 0;
                }
            }
        }while(!ok);

        do {

            printf("Partenza: ");
            gets(voli->volo[voli->numeroVoli].part); 
            printf("Arrivo: ");
            gets(voli->volo[voli->numeroVoli].dest);

            //Controllo se partenzå e arrivo sono uguali
        }while(strcmp(voli->volo[voli->numeroVoli].part, voli->volo[voli->numeroVoli].dest) == 0);

        do {
            printf("Costo: ");
            scanf("%f", &voli->volo[voli->numeroVoli].costo);

        }while(voli->volo[voli->numeroVoli].costo < 0);

        do {
            printf("NumPosti: ");
            scanf("%d", &voli->volo[voli->numeroVoli].maxPasseggeri);
        }while(voli->volo[voli->numeroVoli].maxPasseggeri < 0);

        for(int i = 0; i < MAXGIORNI; i++) {
            voli->volo[voli->numeroVoli].postiLiberi[i] = voli->volo[voli->numeroVoli].maxPasseggeri; 
        }

        voli->numeroVoli++;

    }
};

void visualizzaVoli(voli_t *voli) {

    int i;
    for(i = 0; i < voli->numeroVoli; i++)
    {
        printf("Codice: %s, Partenza: %s, Arrivo: %s, costo: %f, numPosti disponibili: %d", voli->volo[i].cod, voli->volo[i].part, voli->volo[i].dest, voli->volo[i].costo, voli->volo[i].postiLiberi);
    }
}

void prenotaVolo(voli_t *voli) {

    char v[MAXCOD+1];
    int i;
    printf("Quale è il codice del volo da prenotare?");
    scanf("%s", v);
    //Verificare se il codice di volo inserito dall'utente esiste
    int exist = 0;

    for(i = 0, exist = 0; i < voli->numeroVoli && !exist; i++) {
        if(strcmp(v, voli->volo[i].cod) == 0) {
            exist = 1;
        }
    }   

    if(exist) {

        int giorno;
        printf("Giorno che vuole prenotare?");
        do {
            scanf("%d", &giorno);
        }while(giorno < 0 || giorno >= MAXGIORNI);
        
        //Verificare che ci siano posti liberi

        if(voli->volo[i-1].postiLiberi[giorno] == 0) {
            printf("Volo pieno");
        } else{
            voli->volo[i-1].postiLiberi[giorno]--;
        }
    } else {
        printf("Volo non ESISTE\n");
    }

};


void visualizzaPostiLiberi(voli_t *voli) {

    char cod[MAXCOD+1];
    printf("Codice: ");
    scanf("%s", cod);

    int exist = 0;
    int i;
    for(i = 0, exist = 0; i < voli->numeroVoli && !exist; i++) {
        if(strcmp(cod, voli->volo[i].cod) == 0) {
            exist = 1;
        }
    }   

    if(exist) {

        int giorno;
        printf("Giorno che vuoi vedere?");
        do {
            scanf("%d", &giorno);
        }while(giorno < 0 || giorno >= MAXGIORNI);
        
        //Verificare che ci siano posti liberi
        printf("Posti liberi per quel giorno:", voli->volo[i-1].postiLiberi[giorno]);

    } else {
        printf("Volo non ESISTE\n");
    }

}

void mostraVoli(voli_t *voli) {

    char part[MAXNOME+1];
    char dest[MAXNOME+1];
    printf("Partenza: ");
    gets(part);
    do {
        printf("Arrivo: ");
        gets(dest);
    }while(strcmp(part, dest) == 0);

    //Cercare i voli con questa partena e destinazione
    for(int i = 0; i <voli->numeroVoli; i++) {
        if(strcmp(part, voli->volo[i].part) == 0 && strcmp(dest, voli->volo[i].dest) == 0) {
            printf("%s, %f, %d", voli->volo[i].cod, voli->volo[i].costo, voli->volo[i].postiLiberi);
        }
    }

}

void cancellaVolo(voli_t *voli) {
    //Richiedere il codice all'utente
    //Cercare il volo con quel codice
    //Eliminare il volo dall'array 
    //Decremento il numero di voli

    char cod[MAXCOD+1];
    printf("Codice: "); scanf("%s", cod);

    int exist = 0;
    int i;
    for(i = 0; i < voli->numeroVoli && !exist; i++) {
        if(strcmp(cod, voli->volo[i].cod) == 0) {
            exist = 1;
        }
    }
    i--; //indice del volo con il codice inserito dall'utente

    if(!exist) {
        printf("Volo non trovato");
    } else {
        for(int j = i; j < voli->numeroVoli; j++) {
            voli->volo[j] = voli->volo[j+1];
        }
        voli->numeroVoli--;
    }
}