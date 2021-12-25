#include <iostream>
#include <iomanip>
using namespace std;

ostream & ss (ostream & s){
  s << scientific ;
  s << uppercase ;
  return s ;
}

int main(){

  cout << ss << 10.60  ;

}
