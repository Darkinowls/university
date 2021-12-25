#include <iostream>
using namespace std ;

template <class my > class arraytype {
  int size ;
  my *arr ;
public:

arraytype(int s){
  size = s ;
  arr = new my [size];
}

my & operator [](int i) {
  try{
    if ( i > size || i < 0 ) throw i ;
    return arr[i];
    }
  catch(int i){
    cout << "Index value of " << i << " is out of bounds.\n";
    }
  }
};


int main() {
  arraytype <int> obj(5);
  obj[1] = 5 ;
  printf("%d\n", obj[1] );

  arraytype <char> obj1(30);
  obj1[25] = 'g';
  cout <<   obj1[25]  << endl;

  arraytype <string> objs(10);

  objs[0] = "string\n";
  cout << objs[0] ;

  objs [100] = " error " ;


}
