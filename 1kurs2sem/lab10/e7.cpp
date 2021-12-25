#include <iostream>
#include <fstream>
#include <cstring>
#include <string>
using namespace std ;


int main (){

  ofstream f1("e7i.txt");

  f1 << 12345678;
  f1.close();

  ifstream f2("e7i.txt");
  // char t[10];
  string t;
  f2 >> t ;

  ofstream f3 ("e7o.txt");
  f3 << t ;
  f3 << endl << t.size();
//  cout << strlen(t);


}
