#include <iostream>
#include <cstring>
using namespace std;

center (char * s){
  cout.width(40 + strlen(s)/2);
  cout << s ;

}

int main (){
  center ("AAA");
}
