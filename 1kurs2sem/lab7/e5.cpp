#include <iostream>
using namespace std;

class myclass{
  int x , y ;
public :
  myclass (){ x = 0 ; y = 0; }
  myclass (int i ,int j ){ x = i; y = j ; }
  void get_xy (int &i , int &j){ i = x ; j = y ;}
  myclass operator -- ( int inc ){
    x -- ;
    y -- ;
    return *this ;
  }
  myclass operator -- (){
    x -- ;
    y -- ;
    return *this;
  }

  void out(){
    printf("X : %d Y : %d\n",x ,y );
  }

};

int main() {
  int x , y ;
  myclass obj1(10 , 10) ;

obj1 -- ;

 -- obj1;

obj1.out();

}
