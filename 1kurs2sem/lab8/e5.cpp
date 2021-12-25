#include <iostream >
using namespace std;
class mybase {
protected:
 int a, b;
public:
int c;
 void setab(int i, int j) { a = i; b = j; }
 void getab(int &i, int &j) { i = a; j = b; }
};
class derived1 : public mybase {
// ...
};
class derived2 : private mybase {
// ...
};
int main() {
 derived1 obj1;
 derived2 obj2;
 int i = 1, j = 2;
 obj1.getab(i,j);
 obj1.c = 10 ;
 //obj2.getab(i, j); // нічого не зміниться : тип унаслідування private не дозволяє .
//obj2.c = 10 ;

}
