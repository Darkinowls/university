#include <iostream>
#include <fstream>

using namespace std;

int main (){

    fstream f("test.txt");


    f << "Hello World";

    f.seekp(-5, ios::end);

    char A[7];

    f.getline(A , 7);

    cout << A << endl;

}
