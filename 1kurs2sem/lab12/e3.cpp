#include <iostream>
using namespace std ;
#define N 10

template <class C> class stack {
  C stk[N] ;
  int tos ;
public :
  stack(){
    tos = 0 ;
  }

  int push(C data){
    if (tos >= N) {
      cout << "it's a top , bro" ;
      return 0;  // тільки так працює
    }
    stk[tos] = data ;
    tos++ ;
  }

  C & pop(){
    if (tos <= 0 ) {
        cout << "it's a bottom , bro" ;
        return stk[tos] ; // або вихід() можнавикористати
    }
    tos-- ;
    return stk[tos];
  }
};

int main(){
  stack <char> obj ;
  obj.push('a');
  obj.push('b');

  cout << obj.pop();

  stack <int> obji ;
  obji.push(1);
  obji.push(2);

  cout << obji.pop();
 }
