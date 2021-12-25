#include <iostream>
using namespace std ;

int main(){
  cout.setf(ios::showpoint | ios::uppercase | ios::scientific);
  cout << 1.5 << endl << 2323.2 << endl;
}
