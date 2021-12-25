#include <iostream>
using namespace std ;

class date {
 char d[9];
public:
  friend istream & operator >> (istream& stream , date & ob){
    stream >> ob.d ;
    return stream ;
  }
  friend ostream & operator << (ostream& stream , date & ob){
    stream << ob.d ;
    return stream ;
  }
};

int  main() {
  date ob ;
  cin >>  ob ;
  cout << ob ;

}
