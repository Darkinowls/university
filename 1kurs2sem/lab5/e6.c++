#include <iostream>
using namespace std ;

class my {
  int q ;
  char * name;
public:
  in( int l , char n[20]){ q = l ; name = n ;}
  out(){cout << q << ' ' << name <<'\n';}
};

int main(){
  my * p ;
   p = new my ;
   p->in(12345 , "densus");
   p->out();
   delete p ;
}
 
