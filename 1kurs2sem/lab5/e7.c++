#include <iostream>
using namespace std ;

class samp{
  int num ;
  int qual ;
public:
  set_ij( int a , int b ){ num = a ; qual = b;}
  get_product(){return num;}
  ~samp(){cout << "Purge!" << '\n';}
};


int main (){
  samp *ptr ;
  ptr = new samp [10];
  for (int i = 0; i < 10; i++) {
    ptr[i].set_ij(i,i);
  }
  for (int i = 0; i < 10; i++) {
    cout << "Product[" << i << "]is : " ;
    cout << ptr[i].get_product() << "\n";
  }
  delete [] ptr ;
  return 0 ;
}
