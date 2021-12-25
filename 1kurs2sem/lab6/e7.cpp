#include <iostream>

using namespace std;

int n(int a , int b) {return a+b;}
int n(int a , int &b){return a-b;}

void c (unsigned char c){
  cout << c << endl ;
}

void c (char c){
  cout << c << endl ;
}

float f (float t ){
  return t / 2.0 ;
}

double f (double t){
  return t / 3.0 ;
}

int main (){
  float x = 10.09;
  cout << f(x) << endl ;
  double y = 10.09 ;
  cout << f(y)<< endl ;
//  cout << f (10) << endl ;

  c('c');
//  c(5);
  cout << n(1,2) << '\n';

}
