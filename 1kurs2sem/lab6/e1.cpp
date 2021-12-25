#include <iostream>
#include <cstring>
using namespace std;

class strtype {
   char *p;
   int len;
public:
   char *getstring() { return p; }
   int getlength() { return len; }
   strtype(){
     len = 255;
     p = new char[255];
     strcpy(p,"Dorov");
   }
   strtype (char* s){
     len = strlen(s) ;
     p = new char[len];
     strcpy( p , s );
   }
};

int main(){

  strtype ob1;
  printf("%s - %d \n", ob1.getstring() , ob1.getlength() );

  strtype ob2("Honor");
  printf("%s - %d \n", ob2.getstring() , ob2.getlength() );

}
