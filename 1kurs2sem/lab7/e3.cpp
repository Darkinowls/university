#include <iostream>
using namespace std;

class myclass{
  int x , y ;
public :
  myclass (){ x = 0 ; y = 0; }
  myclass (int i ,int j ){ x = i; y = j ; }
  void get_xy (int &i , int &j){ i = x ; j = y ;}
  myclass operator * ( myclass obj ){
    myclass temp ;
    temp.x = x * obj.x ;
    temp.y = y * obj.y ;
    return temp ;
  }
  int operator % ( myclass obj ){ // треба не забувати що вертає функція!
    int temp ;
    temp = x % obj.x ;
    return temp ;
  }
  void out(){
    printf("X : %d Y : %d\n",x ,y );
  }
};

int main() {
  int x , y ;
  myclass obj1(12 , 10) ,obj2(5,3), obj3;
  int b ;
  b = obj1 % obj2 ;
  printf("%d\n", b );
}
