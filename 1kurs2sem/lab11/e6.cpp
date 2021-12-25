#include <iostream>
#include <iomanip>
using namespace std;

class dist{
  double  di ;
public:
  dist (double d){di = d ;}
  virtual trav_dist(){
    cout << di / 60 << endl ;
  }
};

class met : public dist {
  double di;
public:
  met(double d) : dist(d){ di = d ; }
  trav_dist(){
    cout << setprecision(3) << di / 100 << endl ;
  }
};

int main(){
   dist o(120);
   o.trav_dist();

   met a(120);
   a.trav_dist();
}
