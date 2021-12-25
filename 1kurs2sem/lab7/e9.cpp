#include <iostream>
using namespace std;

class myclass{
  int x , y ;
public :
  myclass (){ x = 0 ; y = 0; }
  myclass (int i ,int j ){ x = i; y = j ; }
  void get_xy (int &i , int &j){ i = x ; j = y ;}
  friend myclass operator ++ ( myclass &obj1 , int i ){
    printf("i == %d\n", i );
    obj1.x = obj1.x + i  ;
    obj1.y = obj1.y + i ;
    return obj1 ;
  }
  friend myclass operator ++ ( myclass  &obj1 ){
    obj1.x  = obj1.x + 1 ;
    obj1.y = obj1.y + 1 ;
    return obj1 ;
  }
  void out(){
    printf("X : %d Y : %d\n",x ,y );
  }
};

int main() {
  int x , y ;
  myclass obj1(10 , 10) ,obj2(1 , 1);

  obj1++ ;

  ++obj2 ;

  obj1.out();
  obj2.out();

}
