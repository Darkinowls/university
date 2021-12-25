#include <iostream>
#include <fstream>
using namespace std ;
int main(){

  ofstream fo ("e2.txt");
  fo << "1  2  tabs" ;
  fo.close();

  ifstream fi ("e2.txt");
  char ch[20] ;
  while (!fi.eof()){
    fi.getline(ch,20);
    cout << ch ;
  }




}
