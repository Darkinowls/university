#include <iostream>
using namespace std ;

class another{
  int num ;
public:
  int mix(int i )const{
    const_cast<another*> (this)->num = i ;
    cout << num << endl;
  }
};

int main(){
  another a;
  a.mix(5);
}
