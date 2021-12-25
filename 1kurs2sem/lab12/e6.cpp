#include <iostream>
using namespace std ;

template <class T> T choosen(int size  , T  * arr ){

  class pair{
  public:
    int count ;
    T sign ;
    void operator =(pair * p){
      count = p->count ;
      sign = p->sign ;
    }
  };

  pair * p2 ;
  pair p1 ;
  p1.count = 0 ;

  for (int i = 0; i < size; i++) {

    p2 = new pair  ;
    p2->sign = arr[i];

    for (int j = 0; j < size; j++) {
      if ( p2->sign == arr[j] ) p2->count ++ ;
    }
    if (p2->count >= p1.count){
      p1 = p2 ;
      delete p2 ;
     }
  }
  return p1.sign ;
}

int main(){
  int arr1[10] = { 2 , 4 , 4 , 4 , 5 , 4 , 2 , 4 , 4 , 1 } ;
  cout << choosen( 10 , arr1 ) << endl ;

  char arr2[10] = {'a', 'b' , 'c' , 'a' , 'c' , 'b' , 'h' , 'h' , 'c' , 'c' } ;
  cout << choosen( 10 , arr2 ) ;
}
