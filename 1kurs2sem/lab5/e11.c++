#include <iostream>
using namespace std ;

neg(int *a){
  cout << -*a << '\n';
}

neg (int &a){
  cout << -a << '\n';
}

int main (){
  int i = 5 ;
  neg(&i);

  int q = 10 ;
  neg (q);
}
