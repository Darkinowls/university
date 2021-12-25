#include <iostream>
#include <iomanip>
using namespace std;

int main(){
  cout << 100 << endl ;
  cout << hex << 100 << endl ;
  cout << oct << 100 << endl ;

  cout.setf(ios:: left );
  cout << setw(20)  << setprecision(6) << setfill('*') <<1000.5364 ;

}
