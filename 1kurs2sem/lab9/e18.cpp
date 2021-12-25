#include <iostream>
#include <iomanip>
using namespace std;

class box {
  int a ;
public :
  box(int side){
    a = side ;
  }
  friend ostream & operator << (ostream & stream , box &ob ){
    stream << ' ' << setfill('_') << setw(ob.a*2) << ' ' <<  endl << setfill(' ');
    for (int i = 0; i < ob.a; i++) {
      stream << '|' << setw(ob.a*2) << '|' <<endl;
      if(i == ob.a-2) cout << setfill('_');
    }
  return stream;
  }
};

int main(){
  box ob1(2);
  cout << ob1 ;
  box ob2(5);
  cout << ob2 ;
  box ob3(10);
  cout << ob3 ;
}
