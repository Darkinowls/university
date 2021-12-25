#include <iostream>
// math lib doesnt work
using namespace std ;


class Pwr {
 int base;
 int exp;
public:
 Pwr(int b, int e) { base = b; exp = e; }
 operator int (){
   int out = 1 ;
   for(int i = 0 ; i < exp ; i++){
    out *= base ;
   }
   return out;
 }
};

int main(){
  Pwr i(4,3);
  cout << i ;


}
