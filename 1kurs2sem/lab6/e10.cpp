#include <iostream>
#include <cstring>
using namespace std;

void rev(char *str, int counter = 0){
    int j;
    if(counter == 0) j = strlen(str) - 1 ;
    else j = counter;
    char temp;
    for(int i = 0; i < j; i++, j--){
        temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }
}

int main() {
    char * p = new char[50];
    cin >> p ;
    rev(p, strlen(p)-1);
    cout << p << endl;
    rev(p);
    cout << p << endl;
    delete [] p;
    return 0;
}
