#include <iostream>
#include <fstream>
#include <cstring>
using namespace std ;

class ltr{
public:
  char name  ;
  int num ;
};

int size = 1 ;
ltr ob[100] ;

check( char a){
  for (int i = 0; i < size; i++) {
    if( ob[i].name == a) {
      ob[i].num++;
      break;
    }
    if (!ob[i].name ){
      ob[i].name = a ;
      ob[i].num++;
      size++;
      break;
    }
  }
}

int main(){

  ifstream in ("e19i.txt") ;
  char arr[100];
  for (int i = 0; !in.eof(); i++) {
    in.get(arr[i]);
  }
  int s = strlen(arr) - 2 ;  // without /0  /n
  for (int i = 0; i < s; i++) {
    check ( arr[i] );
  }

  for (int i = 0; i < size; i++) {
    if (!ob[i].num) break;
    printf("%d : %c \n",ob[i].num , ob[i].name );
  }
}
