#include <iostream>
#include <fstream>
using namespace std;

int main(){
  ifstream in ("phones.txt");
  char ch[10] ;
  int counter = 0 ;
  while(!in.eof()) {
    in >> ch ;
    counter ++ ;
  }
  printf("%d\n", counter );
}
