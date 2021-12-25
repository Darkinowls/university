#include <iostream>
#include <ctime>
using namespace std ;

class watch {
  time_t t ;
public:
  watch(){
    t = time(NULL);
  }
  friend ostream & operator << (ostream& stream , watch & ob){
    stream << ctime(&ob.t) ;

    return stream ;
  }
};

int main (){

  watch ob ;
  cout << ob ;


}
