#include <iostream>
#include <cstring>
#include <Windows.h>

using namespace std;

void myclreol(int len){

  for (int i = 0; i < len; i++) {
      cout << '\b';
  }
  for (int j = 0; j < len-1; j++) {
      cout << ' ';
  }
}


int main() {

  char l[10];
  scanf("%s", l );
  int len ;
  printf("press 0 to take all\n" );
  cin >> len ;
  if (len == 0) {
    len = strlen(l);
  }

  printf("%s", l);
  Sleep(2000);
  myclreol(len);

  }
