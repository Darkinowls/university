#include <iostream>
using namespace std ;

class samp {
  int a,b;
public:
  samp(int n , int m){ a = n ; b = m; }
  int get_a(){return a;}
  int get_b(){return b;}
};

int main (){
  samp obj[4] = { samp(1,2) ,samp(3,4),
                  samp(5,6) ,samp(7,8)};
  samp * p ;
  p = obj + 3 ; // кординати
  for (int i = 4; i > 0 ;  i--) {
    cout << p->get_b() << ' ';
    cout << p->get_a() << '\n';
    p--; // координати
  }
  cout << endl;
}
