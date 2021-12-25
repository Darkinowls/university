#include <iostream>
#include <fstream>
#include <string>
using namespace std;

int main(){
  ifstream in ("phones.txt");
  char ch ;
  int counter = 0 ;
  while(!in.eof()) {
    in.get(ch) ;
    if (ch == ' ' || ch == '\n' ) counter ++ ;
  }
  printf("%d\n", counter );
///
  ofstream f1("e7i.txt");

  f1 << 12345678;
  f1.close();

  ifstream f2("e7i.txt");
  string t;
  f2 >> t ;

  ofstream f3 ("e7o.txt");
  f3 << t ;
  f3 << endl << t.size();

}
