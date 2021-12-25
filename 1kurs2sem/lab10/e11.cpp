#include <iostream>
#include <fstream>
#include <cstring>
using namespace std ;

class account {
   int custnum;
   char name[80];
   double balance;
public:
   account(int c, char *n, double b) {
   custnum = c;
   strcpy(name, n);
   balance = b;
   }
   friend ostream &operator << (ostream & o , account &ob){
     o <<"ID " << ob.custnum  << endl;
     o <<"Name " <<ob.name << endl ;
     o <<"Money " <<ob.balance ;
     return o ;
   }
};

int main(){
  account ob(123 , "Densus" , 0.1 );
  ofstream fout("e11.txt");
  fout << ob ;
  cout << ob ;


}
