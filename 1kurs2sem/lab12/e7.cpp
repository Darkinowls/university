#include <iostream>
using namespace std ;

template <class t> int  sum( t * arr , int size){

  int sum = 0 ;
  for (int i = 0; i < size; i++) {
    sum = sum + arr[i];
  }
  return sum ;
}


int main(){
  int arr[10];
  for (int i = 0; i < 10; i++) {
    arr[i] = i ;
  }
  cout << sum( arr , 10 ) << endl;


  char arra[10];
  for (int i = 0; i < 10; i++) {
    arra[i] = 'a' + i ;
  }
  cout << sum( arra , 10 );
}
