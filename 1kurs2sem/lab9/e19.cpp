#include <iostream >
using namespace std;
#define SIZE 10

class stack {
 char stck[SIZE];
 int tos;
public:
 stack();
 void push(char ch);
 char pop();
 friend ostream & operator << (ostream & stream , stack& ob){
   for (int i = ob.tos-1; i >= 0; i--) {
     stream << ob.stck[i];
   }
   return stream ;
 }
};


stack::stack() {
 tos = 0;
}

void stack::push (char ch) {
 if (tos == SIZE) {
 cout << "Stack is full\n";
 exit(0);
 }
 stck[tos] = ch;
 tos++;
}

char stack::pop() {
 if (tos==0) {
 cout << "Stack is empty\n";
 exit(0);
 }
 tos--;
 return stck[tos];
}

int main(){
  stack ob;
  ob.push('a');
  ob.push('g');
  ob.push('o');
  ob.push('r');
  ob.push('p');
  cout << ob;
}
