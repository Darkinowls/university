#include <iostream>
using namespace std;

int main(){
  cout.setf(ios:: left );
  cout.fill('*');
  cout.width(20);
  cout.precision(6);
  cout <<1000.5364 ;
}
