#include <iostream>
#include <cstring>
using namespace std;

class mybase {
 char str[80];
public:
 mybase(const char *s){ strcpy (str, s); }
 char *get() { return str; }
};
class myderived : public mybase {
 int len;
public:
 myderived(const char *s):mybase(s){
   len = strlen(s)+1 ;
 }
 int getlen() { return len; }
 void show() { cout << get () << '\n'; }
};

int main() {
 myderived ob("hello");
 ob.show();
 cout << ob.getlen() << '\n';
}
