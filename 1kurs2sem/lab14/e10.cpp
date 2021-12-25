#include <iostream>
#include <strstream>
using namespace std;

int main(){
  char buf[25] = "1.5556";
  istrstream istr(buf , 5  );
  double num ;
  istr >> num;
  cout << num ;

}
