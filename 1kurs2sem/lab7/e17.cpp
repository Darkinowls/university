#include <iostream>
#include <cstring>
#include <cstdlib>

class strcls{
  int len ;
  char *p;
public:
  strcls(const char* s = " "){
    p = new char[len = strlen(s)+1];
    if (!p) {
      exit(-1);
    }
    strcpy(p , s);
  }
  out(){
    printf("%s\n", p );
  }
  void operator +(strcls ob){
    strcat(p,ob.p);
    len = len + ob.len - 1 ;
  }

  void operator =(strcls ob){
    if (len > ob.len) {
      strcpy (p , ob.p);
    }else{
      delete [] p ;
      p = new char[ob.len];
      strcpy (p , ob.p);
    }
  }
  int operator >(strcls ob){
    if (len > ob.len) {
      return 1;
    }else{
      return 0 ;
    }
  }

  int operator <(strcls ob){
    if (len > ob.len) {
      return 0;
    }else{
      return 1 ;
    }
  }

  int operator ==(strcls ob){
    if (strcmp (p,ob.p) == 0) {
      return 1;
    }else{
      return 0 ;
    }
  }

};

int main (){
  strcls ob1("Dan") , ob2("ce") , ob3("changes!") ;
  ob1 + ob2;
  ob1.out();
  ob1 = ob3 ;
  ob1.out();

  if (ob2 > ob3){
    printf("AAA\n" );
  }

  if (ob2 < ob3){
    printf("ob2 < ob3\n" );
  }

  if(ob3 == ob3){
    printf("EQUAL\n" );
  }


}
