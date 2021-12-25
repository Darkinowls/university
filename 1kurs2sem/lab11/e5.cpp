#include <iostream>
#include <iomanip>
using namespace std ;

class Num {
  int number ;
public:
  Num( int x ) { number = x ;}
  virtual fun(){
    cout << dec << number << endl ;
  }
};

class octnum : public Num {
  int number ;
public:
  octnum( int x ) : Num(x) { number = x ;}
  fun(){
    cout << oct << number << endl ;
  }
};

class hexnum : public Num {
  int number ;
public:
  hexnum( int x ) : Num(x) { number = x ;}
  fun(){
    cout << hex << number << endl ;
  }
};

int main(){
  octnum o(9);
  hexnum a(15);
  Num  n(12);

  Num * ptr ;

  ptr = & o ;
  ptr->fun();

  ptr = & a ;
  ptr->fun();

  ptr = & n ;
  ptr->fun();

}
