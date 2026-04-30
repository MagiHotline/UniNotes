#include <stdio.h>
#include <string.h>
#define LINE 255
#define INDEX_LINES 0
#define INDEX_CHARS 1
#define INDEX_LETTERS 2

void text_analysis(const char *filename, int *data);
int countLetters(char *);

int main() {
    // Scrivere un programma C che analizza il contenuto di in file restituendo (A) il # di righe, (B) Il # di caratteri (C) # Il numero di lettere
    FILE *fid;
    int data[] = {0, 0, 0};
    text_analysis("file.txt", data);

    printf("Numero di righe: %i\n", data[INDEX_LINES]);
    printf("Numero di caratteri: %i\n", data[INDEX_CHARS]);
    printf("Numero di lettere: %i\n", data[INDEX_LETTERS]);

    return 0;
}

// Per sicurezza, bisognerebbe aggiungere la dimensione
int countLetters(char *riga) {
    int count = 0;
    for(int i = 0; riga[i] != '\0'; i++) {
        if((riga[i] > 'A' && riga[i] < 'Z') ||(riga[i] > 'a' && riga[i] < 'z')) count++;
    }

    return count;
}


void text_analysis(const char *filename, int *data) {

    FILE *fid = fopen(filename, "r");
    char riga[LINE];

    if(!fid) {
         printf("Cannot open file");
    } else {

        while(fgets(riga, LINE, fid)) {
            data[INDEX_LINES]++;

            // Controlliamo se c'è stato un eccesso e quindi se ci sta effettivamente \n
            if(riga[strlen(riga)-1] == '\n') {
                riga[strlen(riga)-1] = '\0';
            }

            data[INDEX_CHARS] += strlen(riga);
            data[INDEX_LETTERS] += countLetters(riga);

        }

        fclose(fid);
    }


}
