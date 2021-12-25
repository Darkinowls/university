#include <iostream>
using namespace std ;

class  myclass{
int a ;
public:
explicit myclass(int x) { a = x; }
         myclass(char *str) { a = atoi(str); }
int geta(){return a;}

};


int main(){
  myclass obj1(4) ;
  myclass obj2 = "123";
  cout << obj2.geta();

}
