#include <iostream>
#include <string>
using namespace std ;

class one{
  int num ;
public:
  one(int i = 0 ){num = i;} // масиви автоматично не перетвоюються!

  ~one(){
    cout << num << endl ;
  }
  operator = (const char * a){
  num = stoi(a);
  }

};


int main(){
  one obj = 4 ;

  one objs ;

  objs = "123";

// масиви автоматично не перетвоюються!
}
