#include <iostream>
#include <iomanip>
using namespace std ;

ostream & tab(ostream & s){
  s << "\t\t\t";
  s.width(20) ;
  return s ;
}

int main(){
  cout << tab << "AAA";

}
