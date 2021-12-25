#include <iostream>
using namespace std;

class myclass{
  int x , y ;
public :
  myclass (){ x = 0 ; y = 0; }
  myclass (int i ,int j ){ x = i; y = j ; }
  void get_xy (int &i , int &j){ i = x ; j = y ;}
  friend myclass operator * ( int i , myclass obj2 ){
    myclass temp ;
    temp.x = i * obj2.x ;
    temp.y = i * obj2.y ;
    return temp ;
  }
  friend  myclass operator * ( myclass  obj1 , int i ){
    myclass temp ;
    temp.x  = obj1.x * i ;
    temp.y = obj1.y * i ;
    return temp ;
  }
  void out(){
    printf("X : %d Y : %d\n",x ,y );
  }
};

int main() {
  int x , y ;
  myclass obj1(10 , 10) ,obj2(1 , 1);

  obj1 = obj1 * 5 ;

  obj2 = 10 * obj2  ;

  obj1.out();
  obj2.out();

}
