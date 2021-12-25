#include <iostream>
#include <fstream>
#include <string>
using namespace std ;

int main(){
  ofstream f("phones.txt");
  string name , num ;
  cout <<"name : " ;
  cin >>name ;
  for(;;){
  cout <<"number : " ;
  cin >> num ;
  f << endl <<name << " " << num ;
  string cont;
  cout << "stop('y') or enter name : " ;
  cin  >> cont  ;
    if (cont == "y") break;
  name = cont ;
  }
}
