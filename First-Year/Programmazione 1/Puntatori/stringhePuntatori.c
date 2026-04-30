#include <stdio.h>

int strlen(char[]);

int main() {

    char stringa[1024];
    int l;
    gets(stringa);

    l = strlen(stringa); // 

    printf("%d\n",l);

    return 0;
}

int strlen(char stringa[]) {
    int i;
    for(i = 0; stringa[i] != '\0'; i++);
    return i;
}
