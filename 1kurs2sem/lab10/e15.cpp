#include <iostream>
#include <fstream>
using namespace std ;

int main(){

  ifstream in ("e11.txt");
  char a[100];
  int i = 0 ;
  for (; !in.eof(); i++) {
    in.get(a[i]);
  }
  i = i - 2 ; // /n /0
  for ( ; i > 0 ;i--) {
    cout << a[i];
  }

}
