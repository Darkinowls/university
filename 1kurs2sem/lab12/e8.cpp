#include <iostream>
using namespace std ;

template <class t> void  sort( t * arr , int size){


  for (int i = size/2; i < size; i++) {
    for (int j = 0; j < size; j++) {
      if (arr[i] > arr[j]) {
        t temp;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp ;
      }
    }
  }
  for (int k = 0; k < size; k++) {
    cout << arr[k];
  }
}


int main(){
  int arr[10];
  for (int i = 0; i < 10; i++) {
    arr[i] = i ;
  }

  sort( arr , 10 );


}
