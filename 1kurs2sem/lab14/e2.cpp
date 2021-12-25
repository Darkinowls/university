#include <iostream>
#include <cstring>
using namespace std ;

class strtype {
  char str[80];
  int len ;
  public :
  strtype(const char * s) {
      strcpy(str , s);
      len = strlen(s);
  }
  operator int (){return len;}
};

int main(){
  strtype s ("This is a test");
  int i ;
  i = s ;
  cout << i ;
}
