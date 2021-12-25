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
  three_d operator +(int i){
    three_d temp;
    temp.x = x + i ;
    temp.y = y + i ;
    temp.z = z + i ;
    return temp ;
  }

  three_d operator +(three_d &obj){
    three_d temp;
    temp.x = x + obj.x ;
    temp.y = y + obj.y ;
    temp.z = z + obj.z ;
    return temp ;
  }
  friend three_d operator +(  int i , three_d &obj){
    three_d temp;
    temp.x = i + obj.x ;
    temp.y = i + obj.y ;
    temp.z = i + obj.z ;
    return temp ;
  }
  three_d operator -(three_d &obj){
    three_d temp;
    temp.x = x - obj.x ;
    temp.y = y - obj.y ;
    temp.z = z - obj.z ;
    return temp ;
  }

  friend operator --(three_d &obj){
    obj.x = obj.x - 1 ;
    obj.y = obj.y - 1 ;
    obj.z = obj.z - 1 ;
  }

  friend operator ++(three_d &obj){
    obj.x = obj.x + 1 ;
    obj.y = obj.y + 1 ;
    obj.z = obj.z + 1 ;
  }

  int operator ==( three_d obj){
    if (x==obj.x && y==obj.y && z==obj.z) {
      return 1;
    }else return 0 ;
  }

  int operator ||( three_d obj){
    if (x==2 || obj.x==2) {
      return 1;
    }else return 0 ;
  }

  int operator !=( three_d obj){
    if (x!=obj.x || y!=obj.y || z!=obj.z) {
      return 1;
    }else return 0 ;
  }

};

int main() {
  three_d obj1(5,6,7) , obj2(1,2,3) , obj3;

  obj3 = obj1 + obj2;
  obj1 = obj3 - obj3;
  obj1.out();
  obj3.out();
  puts("");

  ++obj1;
  --obj3;
  obj1.out();
  obj3.out();
  puts("");

  obj1 = obj2 + 1 ;
  obj1 = 1 + obj2 ;
  obj1.out();
  puts("");

  if (obj1 == obj1) {
    printf("abviously equal\n" );
  }

  if (obj1 != obj2) {
    printf("abviously unequal\n" );
  }

  if (obj1 || obj2) {
    printf("there are \'2\'\n" );
  }

}
