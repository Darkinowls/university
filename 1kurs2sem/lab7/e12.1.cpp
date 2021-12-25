#include <iostream>
#include <cstring>
#include <cstdlib>
using namespace std ;

class strtype {
  char * ptr ;
  int len ;
public:
  strtype(char * s){
    len = strlen(s) + 1 ;
    ptr = new  char [len];
    if(!ptr) exit(-1);
    strcpy(ptr , s);
  }
  ~strtype(){
    printf("Freeeeeing\n" );
    delete [] ptr;
  }
  char& operator [](int i ){
    if ( i < 0 || i > len) exit(-1);
    return ptr[i];
  }

};
int main() {
  strtype obj("Denus");

  printf("%c\n", obj[3] );

}
