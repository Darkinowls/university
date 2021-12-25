#include <iostream>
#include <cstring>
#include <iomanip>
#include <cmath>
using namespace std;

center (char * s){
  cout << setw(40 + strlen(s)/2) << s << endl ;

}

int main (){
  center ("AAA");
  for (int i = 2; i <= 100; i++) {
    cout << setw(10) << i << " : " << log(i) << " " << log10(i) << endl ;
  }
}
