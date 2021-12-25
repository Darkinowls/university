#include <iostream>
using namespace std;

class myclass{
  int size ;
  char * p ;
public :
  myclass (int num){
    p = new char[size = num];
    if(!p) exit(0);
   }
   char &operator[](int i){
     if (i<0 || size <= i ) {
       exit(0);
     }
     return p[i];
   }
   ~myclass(){
     for (int i = 0; i < size; i++) {
       printf("%c ", p[i] );
     }
     printf("\n");
     delete [] p ;
   }

};
int main() {
  myclass obj(5);
  for (int  i = 0; i < 5; i++) {
    obj[i] = 'a'+i ;
  }
}
