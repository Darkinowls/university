#include <iostream>
using namespace std;

int main(){

  ios::fmtflags f ;
  cout.setf(ios::left);
  f = cout.flags();

  if (f & ios::right) {
    cout << "right";
  }else
    if (f & ios::left) {
      cout << "left";
    }else cout << "NO";
}
