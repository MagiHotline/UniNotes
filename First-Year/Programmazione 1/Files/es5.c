//Stampare a video stringhe che sono formate solo da caratteri alfanumeri
//e stampa a video quelle formate solo da caratteri alfanumerici


#include <stdio.h>

#define filename "testo.txt"
#define MAXS 15

int main() {

    FILE *file = fopen(filename, "r");
    char s[MAXS + 1];
    int ok, i;
    if(file) {

        fscanf(file, "%s", s);
        while(!feof(file)) {

            for(i = 0, ok = 1; s[i] != '\0' && ok; i++) {
                if(s[i] < 0 || s[i] > 9) {
                    ok = 0;
                }
            }

            if(ok) {printf("%s\n", s);}
            fscanf(file, "%s", s);
        }

        fclose(file);
    }


    return 0;
}
