#include <stdio.h>

#define LINE 255

int main() {

    FILE *fid;
    //Apertura File
    fid = fopen("file.txt", "r");
    char riga[LINE];
    //Verificare risultato dell'apertura'
    if(fid) {

       fgets(riga, LINE, fid);
       while(!feof(fid)) {
           printf("%s", riga);
           // Mi legge una riga intera
           fgets(riga, LINE, fid);
       }

       fclose(fid);

    } else {
        printf("Cannot Open File");
    }


    return 0;
}
