#include <iostream>
using namespace std;

void invertiarray(int *vet , int dimensione)
{
    int supp;
    for(int i=0; i<dimensione/2;i++)
    {
        supp = *(vet+i);
        *(vet+i) = *(vet+(dimensione-1-i));
        *(vet+(dimensione-1-i)) = supp;
    }
}


int main() {

    int v[] = {1,2,3,4,5,6,7,8,9,10};
    int dim = 10;

    invertiarray(v, dim);

    for(int i = 0; i < dim; i++) {
        cout << v[i] << "\t";
    }

    return 0;
}
