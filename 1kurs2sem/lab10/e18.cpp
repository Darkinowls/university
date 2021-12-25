#include <iostream>
#include <iomanip>
#include <locale>
using namespace std ;


istream &findalpha(istream & s){
  char ch ;
  for (;;) {
    s.get(ch);
    if (isalpha(ch)) {
      printf("%c\n", ch );
      break;
    }
  }
  return s;
}

int main(){

  cin >> findalpha;

}
