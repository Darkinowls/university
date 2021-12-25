#include <iostream>
using namespace std;

class myclass{
  int x , y ;
public :
  myclass (){ x = 0 ; y = 0; }
  myclass (int i ,int j ){ x = i; y = j ; }
  void get_xy (int &i , int &j){ i = x ; j = y ;}
  friend myclass operator - ( myclass obj1 , myclass obj2 ){
    myclass temp ;
    temp.x = obj1.x - obj2.x ;
    temp.y = obj1.y - obj2.y ;
    return temp ;
  }
  friend  void operator / ( myclass &obj1 , int i ){
    obj1.x = obj1.x / i ;
    obj1.y = obj1.y / i ;

  }
  void out(){
    printf("X : %d Y : %d\n",x ,y );
  }
};

int main() {
  int x , y ;
  myclass obj1(10 , 10) ,obj2(5,3) , obj3;

  obj3 = obj1 -obj2 ;

  obj1 / 5 ;

  obj1.out();
  obj3.out();

}
