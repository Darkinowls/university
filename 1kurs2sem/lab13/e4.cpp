#include <iostream >
using namespace std;

void f(const double &i) {
double * pi ;
pi = const_cast <double* > (&i);
*pi = 100 ;
}






double * vol = new double  ;
void example1 ( const double &i ){
vol  = const_cast <double *>(&i)  ;
}





int main() {
 double x = 98.6;
 cout << x << endl;
 f(x);
 cout << x << endl;
//////////////
  cout << "Volatile constant by pointer" << endl ;
 example1(x);
 cout << x << endl;
 *vol = rand() % 10 ;
  cout << x << endl ;
  *vol = 20 ;
   cout << x << endl ;
///////////////
  cout << "reference time !" << '\n';
  const int & num = 5 ;
  int & m = const_cast <int & > (num) ;
  cout << num << endl ;
  m = 10 ;
  cout << num << endl ;



}
