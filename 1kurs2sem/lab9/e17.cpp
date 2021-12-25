#include <iostream>
using namespace std;

class pwr {
 int base;
 int exponent;
 double result; // base to the exponent power
public:
 pwr(int b, int e);
 friend ostream& operator << (ostream & stream , pwr & ob){
   stream << ob.result ;
   return stream;
 }
 friend istream& operator >> (istream & stream , pwr & ob){
   printf("\nbase : ");
   stream >>  ob.base ;
   printf("exponent : ");
   stream >> ob.exponent ;
   ob.result = 1;
   for ( ; ob.exponent; ob.exponent--)
   ob.result = ob.result * ob.base;
   return stream;
 }
};

pwr::pwr(int b, int e) {
 base = b;
 exponent = e;
 result = 1;
 for ( ; e; e--)
 result = result * base;
}

int main (){
  pwr obj(2,2);
  cout << obj ;
  cin >> obj ;
  cout << obj ;
}
