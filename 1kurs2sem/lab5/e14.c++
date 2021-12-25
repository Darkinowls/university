#include <iostream>
#include <cstring>
#include <cstdlib>
using namespace std ;

class strtype{
  char *p;
  int len ;
public:
  strtype();
  ~strtype();
  void set (char const * ptr);
  void show();
};

strtype::strtype(){
  p = new char[255];
  if(!p){
    cout << "Alocation error.\n";
    exit(1);
  }
  *p = '\0';
  len = 0 ;
}

strtype::~strtype(){
cout << "Deleting\n" ;
delete [] p ;
}

void strtype::set(char const *ptr){
  if (strlen(ptr) > 255 ) {
    cout << "String too big \n";
    return ;
  }
  strcpy (p , ptr);
  len = strlen(p);
}

void strtype::show(){
  cout << p << "- lenght : " << len ;
  cout << '\n';
}

int main (){
  strtype s1 , s2 ;
  s1.set("this is a test.");
  s2.set("Ilike C++");
  s1.show();
  s2.show();
}
