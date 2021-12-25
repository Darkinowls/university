#include <iostream>
using namespace std ;

double divide (double a, double b) {

  try {
    if(!b) throw b;
  }

  catch (double b) {
    cerr << "can't divide by ";
    return 0 ;
  }
  return a/b;
}

int main(){
  cout  << divide( 1 , 2 ) << endl;
  cout  << divide( 1 , 0 );
}
