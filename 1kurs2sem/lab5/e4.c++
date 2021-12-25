#include <iostream>
using namespace std ;

class samp {
  int a ;
public:
  samp( int n ){ a = n ; }
  int get_a(){ return a; }
};

int main (){
  samp obj [4][2]{ { 1 , 2 },
                   { 3 , 4 },
                   { 5 , 6 },
                   { 7 , 8 }, };
samp * p ;
 p = obj[0];
 for (size_t i = 0; i < 8; i++) {
   cout << p->get_a() << '\n';
   p++;
 }
}
