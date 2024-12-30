/*Scrivere un codice in c++ che preveda le seguenti operazioni:
1) Dichiarazione di un vettore di struct (string nome, int eta).
2) Riempimento da parte dell’utente di un vettore di N elementi ( chiesto in input) di tale struct.
3) Stampa del vettore.*/

#include <iostream>

using namespace std;

typedef struct Persona {
    string nome;
    int eta;
} Persona;

void riempiArray(Persona v[], int dim) {
    for(int i = 0; i < dim; i++) {
        cout << "Inserisci nome: " << endl;
        cin >> v[i].nome;
        cout << "Inserisci eta': " << endl;
        cin >> v[i].eta;
    }
}

void stampaArray(Persona v[], int dim) {
    for(int i = 0; i < dim; i++) {
        cout << v[i].nome << " : " << v[i].eta << endl;
    }
}



int main() {

    int dim;
    cout << "Inserire dimensione array: " << endl;
    cin >> dim;

    Persona vettore[dim];

    riempiArray(vettore, dim);

    stampaArray(vettore, dim);

    return 0;
}
