#include <iostream>
#include <typeinfo>
#include <cmath>
#include <cstdlib>

using namespace std ;

template <class T> class Num{
public:
T x ;
Num (T i) { x = i ;}
virtual T get_val(){return x ;}
};

template  <class T> class Square : public Num <T> {
public:
  Square (T i): Num<T> (i) {}
  T get_val(){return this -> x * this -> x;}

};

template   <class T> class Sqr_root : public Num <T> {
public:
  Sqr_root (T i): Num <T> (i) {}
  T get_val(){return sqrt((double) this-> x ); }

};

Num <double > * generator (){
  try{
    switch (rand () % 2 ) {
      case 0 : return new Square  <double >  (rand ()% 100 );
      case 1 : return new Sqr_root <double > (rand () % 100 ) ;
    }
  }catch(bad_alloc xa){
    cout << "Bad allocation!";
    return NULL ;
  }
  return NULL ;
}

int main(){
  Num <double> *p , obn(4);
  Square <double> obs (5);
  Sqr_root <double> obr(25) ;

  p = &obs ;
  cout << p ->get_val() << endl;

  p = dynamic_cast < Num <double> * > (p);

  p = generator();

  cout << p -> get_val();





}
