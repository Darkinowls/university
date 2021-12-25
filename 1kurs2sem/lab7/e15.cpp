#include <iostream>
using namespace std ;

class three_d {
  int x, y, z;
public:
  three_d(int i = 0, int j = 0, int k = 0) { x=i; y=j; z=k; }
  void get(){

  }
  out(){
    printf("x : %d , y : %d , z : %d \n",x , y , z );
  }

  three_d operator +(three_d obj){
    three_d temp;
    temp.x = x + obj.x ;
    temp.y = y + obj.y ;
    temp.z = z + obj.z ;
    return temp ;
  }
  three_d operator -(three_d obj){
    three_d temp;
    temp.x = x - obj.x ;
    temp.y = y - obj.y ;
    temp.z = z - obj.z ;
    return temp ;
  }

  operator --(){
    x = x - 1 ;
    y = y - 1 ;
    z = z - 1 ;
  }

  operator ++(){
    x = x + 1 ;
    y = y + 1 ;
    z = z + 1 ;
  }

};

int main() {
  three_d obj1(5,6,7) , obj2(1,2,3) , obj3;

  obj3 = obj1 + obj2;
  obj1 = obj3 - obj3;

  obj1.out();
  obj3.out();

  ++obj1;
  --obj3;
  obj1.out();
  obj3.out();

}
