//Massimo comune divisore in maniera ricorsiva

int mcd(int x, int y) {
    if(x == y) {
        return x;
    } else if(x > y) {
        return mcd(x-y, y);
    } else {
        return mcd(x, y-x);
    }
}

#include <stdio.h>

int main() {


    return 0;
}