#include <iostream>
#include <iomanip>
using namespace std ;

ostream & sethex(ostream &stream){
  cout.unsetf( ios :: dec );
  cout.setf(ios:: showbase | ios:: uppercase | ios:: hex ) ;
  return stream ;

}

ostream & unst(ostream &stream){

  cout.unsetf(ios:: showbase | ios:: uppercase | ios:: hex ) ;
  cout.setf( ios :: dec );
  return stream ;

}

int main(){
  cout << sethex << 13 ;

  cout << endl << unst << 13 ;
}
