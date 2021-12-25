#include <iostream >
using namespace std;

class A {
 int i;
public:
 A(int a) { i = a; }
 o1(){
   printf("%d\n", i );
 }
};

class B {
 int j;
public:
 B(int a) { j = a; }
 o2(){
   printf("%d\n", j );
 }
};

class C : public A, public B {
 int k;
public:
  C(int l , int i , int j ) : B(j) , A(i){
    k = l ;
  }
  o3(){
    printf("%d\n", k );
    o1();
    o2();
  }

};

int main (){
  C ob(1,2,3);
  ob.o3();
	
  int i ;
  cin >> i ;


}
