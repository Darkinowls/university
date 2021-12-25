#include <iostream>
using namespace std;

int dif(int a, int b) {
 return a-b;
}
float dif(float a, float b) {
 return a-b;
}

int main (){
  float (*f)(float , float  );
  f = dif ;
  int (*i) (int , int);
  i = dif ;
  printf("%f\n", f(1.2 , 1.2) );
  printf("%d\n", i(2 , 1) );
}
