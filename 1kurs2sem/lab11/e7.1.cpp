#include <iostream>
#include <iomanip>
using namespace std ;



class base{
public:
  virtual void fun(){
    cout << "Using base version of function\n";
  }

};

class der1: public base {
  public :
 /*void fun(){
    cout << "Using derived1 version of function\n";
  } */
};

class der2 : public der1 {
  public :
/*  void fun(){
    cout << "Using derived2 version of function\n";
  } */
};
int main(){
  base * p;
  base obj ;
  der1 obj1;
  der2 obj2;

  p = & obj1 ;
  p-> fun();
  p = & obj ;
  p-> fun();
  p = & obj2 ;
  p-> fun();

  // буде запускатися віртуальна функція класу base

}
