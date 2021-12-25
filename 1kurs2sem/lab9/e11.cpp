#include <iostream>
#include <cstring>
#include <cstdlib>
using namespace std;


class strtype {
 char *p;
 int len;
public:
 strtype(char *ptr);
 ~strtype() { delete [] p; }
 friend ostream &operator <<(ostream &stream, strtype &obj){
   stream << obj.p ;
   return stream;
 }
 friend istream &operator >>(istream &stream, strtype &obj){
   stream >> obj.p ;
   return stream;
 }
};


strtype::strtype(char *ptr = "empty") {
 len = strlen(ptr)+1;
 p = new char(len);
 if (!p) {
 cout << "Allocation error\n";
 exit(1);
 }
 strcpy(p, ptr);
}



int main() {
 strtype s1;
 cin >> s1 ;
 cout << s1 << '\n';
 return 0;
}
