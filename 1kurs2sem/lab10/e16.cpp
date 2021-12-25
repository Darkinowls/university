#include <iostream>
#include <fstream>
using namespace std ;
#define N 10

int main(){

  ofstream f1 ("e16.txt");
  f1 << "1234" ;
  f1.close();

  ifstream f2 ("e16.txt");
  char a[N];
  f2.getline(a , N) ;
  char t   ;
  for (int i = 0; i < N; i = i+2 ) {
     t = a[i];
     a[i] = a[i+1];
     a[i+1] = t ;
  }

  printf("%s\n", a );

}
