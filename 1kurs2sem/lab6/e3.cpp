#include <iostream>
using namespace std;
class myclass {
public:
  myclass();
  myclass( myclass &obj );
  myclass f();
  myclass g(   myclass obj );
};

myclass::myclass() {
  cout << "Constructing normally\n";
}

myclass::myclass( myclass &obj) {
cout << "Constructing copy\n";
}

myclass myclass::f() {
  myclass temp; // 2ий Constructing normally
  return temp;
}
myclass myclass::g(  myclass obj ) {

  printf("fff\n" );
  return obj;
}
int main() {
  myclass obj; // 1ий Constructing normally
  obj = obj.f(); // 1ий Constructing copy
  obj.g(obj); // 2ий Constructing copy
  return 0;
}
