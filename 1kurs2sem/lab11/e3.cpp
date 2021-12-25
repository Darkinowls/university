#include <iostream>
#include <fstream>
#include <cstring>
using namespace std ;

int main( ) {

  ofstream out ("e3.txt");
  out << " word , any word any of any off  ";
  out.close();

  char specialword [10] ;
  cout << "print special word : " ;
  cin >> specialword ;


  ifstream in ("e3.txt");
  char a [10][10];
  int i = 0 ;
  int counter = 0 ;
  while (!in.eof()) {
    in >> a[i];
    if (strcmp( a[i], specialword ) == 0 ) counter ++ ;
    i++ ;
  }
  printf("There are %d of \"%s\"\n", counter , specialword );

}
