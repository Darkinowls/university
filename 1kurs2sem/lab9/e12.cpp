#include <iostream>
using namespace std;

class det_low{
  int num ;
  int lowest;
public:
  friend istream &operator >>(istream & stream  , det_low &ob){
    stream >> ob.num;
    int i;
    for ( i = ob.num + 1 ; ; i++) {
      if(i % ob.num == 0){
        ob.lowest = i ;
        break;
      }
    }
    return stream;
  }
  friend ostream &operator <<(ostream & stream  , det_low& obj){
    stream << "Number : " << obj.num << endl ;
    stream << "Lowest : " << obj.lowest << endl;
    return stream;
  }
};

int main(){
  det_low ob ;
  cin >> ob ;
  cout << ob ;
}
