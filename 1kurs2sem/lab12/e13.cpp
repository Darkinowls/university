#include <iostream>
using namespace std ;



template <class cls> cls abs( cls a ){
  return ( a < 0 )? -a : a ;
}

int main(){

  cout << abs( -5 ) << endl ;

  cout << abs( -5.5 ) << endl ;

  cout << abs( 5 ) << endl ;

  cout << abs( -5L ) << endl ;


}
