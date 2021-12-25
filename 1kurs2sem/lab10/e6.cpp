#include <iostream>
#include <iomanip>
using namespace std ;

int q = 1 ;

istream & skipchar(istream & stream){
  char t ;

    for (int i = 0; i < 5; i++) {
      cin >> t ;
      if(q) cout << t   ;
    }
    cout << endl ;
  q = !q ;
  cin >> skipchar ;
  return stream ;
}




int main(){

  cin >> skipchar  ;

}
