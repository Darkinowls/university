#include <iostream>
using namespace std;

class myclass{
  int x , y ;
public :
  myclass (){ x = 0 ; y = 0; }
  myclass (int i ,int j ){ x = i; y = j ; }
  void get_xy (int &i , int &j){ i = x ; j = y ;}
myclass operator - ( myclass obj1 ){
    myclass temp ;
    temp.x = x - obj1.x ;
    temp.y = y - obj1.y ;
    return temp ;
  }
myclass operator - ( ){
    this->x = -x ;
    y = -y ;
    return *this ;
  }
  void out(){
    printf("X : %d Y : %d\n",x ,y );
  }
};

int main() {
  int x , y ;
  myclass obj1(10 , 10) ,obj2(5,3) , obj3;

  obj3 = obj1 - obj2 ;

  obj3.out();

  obj3 = -obj3 ;

  obj3.out();
}
