//Legge due elenchi ordinati di numeri fa, fb
//E scrive in un file chiamato fc

#include <stdio.h>

int main() {

    FILE *fa, *fb, *fc;
    int a,b;

    if(fa = fopen("elencoa.txt", "r")) {
        if(fb = fopen("elencob.txt", "r")) {
            if(fc = fopen("elencoc.txt", "w")) {


                fscanf(fa, "%d", &a);
                fscanf(fb, "%d", &b);

                // Inizia il ciclo principale

                while(!feof(fa) && !feof(fb)) {
                    
                    if(a == b) {
                        fprintf(fc, "%d\n", a);
                        fscanf(fa, "%d", &a);
                        fprintf(fc, "%d\n", b);
                        fscanf(fb, "%d", &b);
                    } else if(a < b) {
                        fprintf(fc, "%d\n", a);
                        fscanf(fa, "%d", &a);
                    } else {
                        fprintf(fc, "%d\n", b);
                        fscanf(fb, "%d", &b);
                    }
                }

                while(!feof(fa)) {
                    printf(fc, "%d\n", a);
                    fscanf(fa, "%d", &a);
                }

                while(!feof(fb)) {
                    printf(fc, "%d\n", b);
                    fscanf(fb, "%d\n", &b);
                }

                fclose(fc);
            
            } else {
                printf("cannot open elencoc.txt");
                fclose(fa);
                fclose(fb);
            }
        }  else {
            pritnf("Cannot open elencob.txt");
            fclose(fa);
        }
    } else {
        printf("Cannot open elencoa.txt");
    }


    return 0;
}