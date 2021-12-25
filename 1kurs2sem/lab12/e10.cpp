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
    try
    {
      if( tos >= N ) throw tos;

    stk1[tos] = data1 ;
    stk2[tos] = data2;
    tos++ ;
    }
    catch(int tos){
      cout << "it's a top , bro\n" ;
      return 0 ;
    }
  }

  int pop(){
    try {
      if (tos <= 0 ) throw tos ;
    tos-- ;
    cout << stk1[tos] <<" : "<< stk2[tos] << '\n';
    }
    catch(int tos){
      cout << "it's a bottom , bro\n" ;
      return 0 ;
  }
  }
};

int main(){
  stack <char , int > obj ;
  for (int i = 0; i < 11; i++) {
      obj.push ( 'a'+i , i ) ;
  }

  for (int i = 0; i < 11; i++) {
    obj.pop();
  }

 }
