#include <iostream>
#include <iomanip>
using namespace std;

ostream & set(ostream & stream ){
  stream << setfill(':');
  stream << setw(30);
  return stream ;
}


int main() {
cout << set << "I hate C";

}
