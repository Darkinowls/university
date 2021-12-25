#include <iostream>
#include <fstream>
using namespace std ;

int main(){
  ofstream f1 ("e4.txt");
  f1.seekp (81 , ios :: beg );
  f1 << "privit!!!!" ;
}
