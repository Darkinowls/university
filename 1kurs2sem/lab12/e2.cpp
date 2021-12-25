#include <iostream>
using namespace std;
#define N 5

class mt{
  char ch ;
public:
  char& see (){
    return ch ;
  }
};

template <class T> int find(int object, T  *list, int size) {
  return ( (list + object) != NULL )? object : -1 ;
}

int main(){

  mt * list ;

  list =  new mt [N]  ;

  for (int i = 0; i < N; i++) {
    list[i].see() = 'a'+ i ;
  }

    cout  << find ( 1 , list  , N );

}
