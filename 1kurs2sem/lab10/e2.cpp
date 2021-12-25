#include <iostream>
#include <iomanip>
using namespace std ;

int main() {
float a ,b ,c ;
a = 3 ;
b = 10 ;
c = b /a ;
cout.precision(5);
cout << c << endl ;

cout << setprecision(5) << c ;


}
