#include <iostream>
using namespace std ;

class secret {
private:
  static int count ;
  int counter(){
    count++ ;
    return count ;
  }
public:
  void out(){
    cout << counter() << endl ;
  }
};

  int secret :: count ;

int main(){
  secret a , b ;
  a.out();
  a.out();
  b.out();
}
