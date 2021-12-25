#include <iostream>
using namespace std ;
#define N 10

template <class c , class t> class stack {
  c stk1[N] ;
  t stk2[N];
  int tos ;
public :
  stack(){
    tos = 0 ;
  }

  int push(c data1 , t data2 ){
    if (tos >= N) {
      cout << "it's a top , bro" ;
      return 0;  // тільки так працює
    }
    stk1[tos] = data1 ;
    stk2[tos] = data2;
    tos++ ;
  }

  int pop(){
    if (tos <= 0 ) {
        cout << "it's a bottom , bro" ;
        return 0 ;
    }
    tos-- ;
    cout << stk1[tos] <<" : "<< stk2[tos] << '\n';

  }
};

int main(){
  stack <char , int > obj ;
  obj.push ( 'a' , 1 );
  obj.push ( 'b' , 2 ) ;

  obj.pop();
 }
