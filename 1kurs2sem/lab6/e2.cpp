#include <iostream>
#include <ctime>
using namespace std;

class timer {
  clock_t start1;
  clock_t start2;
public:
   timer();
   ~timer();
   timer(clock_t q){
     start1 = q ;
   }
};
timer::timer() {
  start2 = clock();
}

int n = 1 ;

timer::~timer() {
  clock_t end;
  end = clock();
  if (n) {
    cout << "1 : "<< (end-start1) / (double)CLOCKS_PER_SEC  << endl ;
    n = 0 ;
  }else cout << "2 : "<< (end-start2) / (double)CLOCKS_PER_SEC  << endl ;

}



int main() {
  clock_t q = clock();
  timer ob1(q);
  timer ob2;

}
