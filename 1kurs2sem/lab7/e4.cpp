#include <iostream>
using namespace std;

class myclass{
  int x , y ;
public :
  myclass (){ x = 0 ; y = 0; }
  myclass (int i ,int j ){ x = i; y = j ; }
  void get_xy (int &i , int &j){ i = x ; j = y ;}
  int operator > ( myclass obj ){
    myclass temp ;
    if (x > obj.x && y > obj.y   ) {
      return true ;
    }
    return false ;
  }
  int operator < ( myclass obj ){
    myclass temp ;
    if (x < obj.x && y < obj.y   ) {
      return 1 ;
    }
    return 0 ;
  }

};

int main() {
  int x , y ;
  myclass obj1(10 , 10) ,obj2(5,3);

  if (obj1 > obj2) {
    printf("obj1 > obj2\n");
  }
  if (obj1 < obj2) {
    printf("obj1 < obj2\n");
  }

}
