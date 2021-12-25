#include <iostream>
using namespace std ;

class  myclass{
int a ;
public:
explicit myclass(int x) { a = x; }
         myclass(const char *str = "1") { a = atoi(str); }
int geta(){return a;}

};


int main(){
  myclass obj1(4) ;
  myclass obj2 ;
   obj2 = "123"  ; // небажана переініціалізація конструктора
  cout << obj2.geta();

}
// деколи переініціалізація коструктора може поміняти дані обєкта, які не потребують змін
