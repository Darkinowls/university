#include <iostream>
#include <strstream>
using namespace std;




int main(){

const char a [10] = "AAA" ;

char b[10];

ostrstream ostr(b , 10);

ostr << a ;

cout << b ;

}
