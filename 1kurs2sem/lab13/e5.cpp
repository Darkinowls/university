#include <iostream>
#include <typeinfo>

using namespace std;
class A {
 virtual void f() {}
};

class B: public A {};

class C : public A {};

int main() {
 A *p, obja;
 B objb;
 C objc;
 int i;
 cout << "Enter 0 for A objects, ";
 cout << "1 for B objects or ";
 cout << "2 for C objects.\n";
 cin >> i;

 if ( i == 1 )p = &objb;
 else if ( i == 2 ) p = &objc;
 else if ( i == 0 ) p = &obja;
 else main();

 char * name = const_cast <char*> (typeid(*p).name());

 cout << "your class is " << name[1] << endl;


}
