//Ingresso parola:
//SCrivere un pogramma C che mi dia la lunghezza della paroola,
//numero vocali, numero consonanti 

#include <string.h>
#include <stdio.h>

#define DIM 50

int main() {

    char str[DIM+1];

    scanf("%s", str);
    printf("Stringa normale: %s\n", str);

    printf("Lunghezza stringa: %d\n", strlen(str));

    int contavocali = 0, contaconsonanti = 0;
    for(int i = 0; str[i] != '\0'; i++) {
        if(str[i] == 'a' || str[i] == 'e' || str[i] == 'i' || str[i] == 'o' || str[i] == 'u') {
            contavocali++;
        } else {
            contaconsonanti++;
        }
    }

    printf("Numero consonanti: %d\n", contaconsonanti);
    printf("Numero vocali: %d\n", contavocali);

    return 0;
}