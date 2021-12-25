#include <iostream>
#include <fstream>
using namespace std ;

int main(){
  char str[40];
  //cin.getline(str ,39) ;
  for (int i = 0; cin.get(str[i]) ; i++) {
    if (str[i] == '\n' || str[i] == '\0') break;
  }



  printf("%s\n", str );


}
