#include <iostream>
#include <fstream>
#include <locale>
using namespace std ;
#define N 18

int main(){
  ofstream f1("e19i.txt");

  f1 << "not upper letters";
  f1.close();

  ifstream f2("e19i.txt");
  char t[N];
  f2.getline(t,N);

  for (int i = 0; i < N; i++) {
    t[i] = putchar(toupper(t[i]));

  }

  ofstream f3 ("e19o.txt");
  f3 << t ;

}
