#include <iostream>
using namespace std;
#define N 10

class stk{
  int a[N];
public:
  static int tos;
  push(int i){
    if(tos > N){
      cout << "Nope";
    }else a[tos++] = i;
  }

  int pop(){
    if(tos < 0){
      cout << "Nope";
      return 0;
    }
    return a[--tos] ;
  }
};

int stk:: tos;

int main(){
  stk obj1;
  obj1.push(1);

  stk obj2;
  obj2.push(3);

  cout << stk::tos << obj2.pop() << obj1.pop() ;

  cout << stk::tos ;

}
