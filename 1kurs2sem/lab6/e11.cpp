#include <iostream>
using namespace std ;

void order(int &a , int &b ){
  int temp;
  if(a > b){
    temp = a ;
    a = b ;
    b  = temp;
  }
}

int main (){
  int x = 3;
  int y = 2 ;
  order( x , y );
  printf("%d < %d\n", x , y );
}
