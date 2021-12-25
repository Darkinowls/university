#include <iostream>
using namespace std;

class letters {
  char ch;
public:
   letters(char c) { ch = c; }
   char get_ch() { return ch; }
};

int main() {
  letters arr[10] { 'A' , 'B' , 'C' , 'D' , 'E' , 'F' , 'G' , 'H' , 'I' , 'J' };
  for (int i = 0; i < 10; i++) {
    cout << arr[i].get_ch() ;
  }
}
