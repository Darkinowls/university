#include <iostream >
#include <cstdlib >
using namespace std;

long int mystrtol (char str[30], char * ch ){
  long int l  = strtol(str, &ch, 10);
  printf("end : %c\n", *ch );
  return l;
}

int main(){

  char str [30] ;
  cin  >> str ;
  char * ch ;

  printf("%d\n", mystrtol (str , ch ) );
}
