#include <cstdlib>
#include <iostream>
using namespace std ;

int main(){
  int n ;
  int & q = n ;
  int & x = q ;
  int & ref = x ;
  n = 10 ;
  cout << x << ' ' << ref << ' ' << q << ' ' << n <<"\n" ;
}
