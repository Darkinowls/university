#include <iostream>
using namespace std;

int main(){
  cout.unsetf(ios::dec);
  cout.setf(ios::showbase| ios::hex );
  cout << 100 ;
  cout.unsetf(ios::showbase | ios::hex );
}
