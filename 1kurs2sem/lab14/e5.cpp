#include <iostream>
using namespace std ;

class cls{
  int static num;
public:
  operator int(){
    return num;
  }
  cls (){
    num ++ ;
  }
  ~cls(){
    num-- ;
  }
};

int cls :: num = 0 ;
int main(){
  cls o1, o2 ;
  cls * p ;
  p = new cls ;

  cout << o2 << endl;

  delete p ;

  cout << o1 ;

}
