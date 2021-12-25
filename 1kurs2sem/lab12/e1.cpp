#include <iostream>
using namespace std ;


template <class type> type min (type &a , type& b){
  return (a<b)? a : b ;
}



int main(){

  cout << min ( 1 , 5 )  ;
  cout << min ( 'h' ,'c' ) << endl ;
}
