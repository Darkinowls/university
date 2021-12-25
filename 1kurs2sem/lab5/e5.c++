#include <iostream>
using namespace std ;

int main (){
  float * pf ;
  long * pl ;
  char * pc ;

  pf = new float ;
  pl = new long ;
  pc = new char ;

  *pf = 8.5 ;
  *pl = 1L;
  *pc = 'q' ;

  cout << *pf << '\n';
  cout << *pl << '\n';
  cout << *pc << '\n';

  delete pf;
  delete pl;
  delete pc;

}
