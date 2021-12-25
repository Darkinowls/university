#include <iostream>
#include <fstream>
using namespace std ;

int main() {
  ifstream in ("e11.txt");
  char t[20];
  while(!in.eof()){
  in.getline(t , 20);
  cout << t << endl ;
  }
}
