#include <iostream>

using namespace std ;

class cord{
  int x , y  ;
public:
  cord (int a = 12 , int b = 6){
    x = a ;
    y = b ;
  }
  void operator <<(int i){
    x = x << i ;
    y = y << i ;
  }
  void operator >>(int i){
    x = x >> i ;
    y = y >> i ; // бінарний здвиг )
  }
  out(){
    printf("X : %d, Y : %d\n",x , y );
  }

};

int main(){

  cord obj;
  obj << 1 ;
  obj.out();

  obj >> 2 ;
  obj.out();

}
