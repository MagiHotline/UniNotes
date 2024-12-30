//Definire un tipo di dato strutturato per rappresentare le frazioni
//n, d interi
//Scrivere una funzione che riceve come parametro una frazione (passato per ref)
//chiede all'utente il numeratore e il denom e li salva nella variabile ricevuta come parametro
//Scrivere una funzione che riceve come parametro una frazione (passato per ref)
//e la semplifica scrivere 
//Scrivi un main

typedef struct {
    int n;
    int d;
} fract_t;

void semplify(fract_t*);

int main() {

    return 0;
}


void simplify(fract_t *a) {
    int i;
    
    if(a->n != 0) {
        if(a->n < a->d) {
            i = a->n;
        } else {
            i = a->d;
        }

        // Entrambe le condizioni del while devono essere vere per uscire dal while
        while(a->n % i != 0 || a->d % i != 0) {
            i--;
        }

        a->n = a->n/i;
        a->d = a->d/i;
    } else {
        a->d=1;
    }
}