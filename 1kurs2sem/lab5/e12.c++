#include <cstdlib>
#include <iostream>
using namespace std ;

class array {
  int r ;
  int s ;
  int p[2][3];
public:
  array();
  int &put(int i , int j);
  int get(int i , int j );
};

array::array(){;
    r = 2 ;
    s = 3 ;
}

int &array::put(int i , int j){
  if (i < 0 || i >= r || j >= s ) {
    cout << "Bounds error!\n";
    exit(1);
  }
  return p[i][j] ;
}

int array::get(int i , int j ){
  if (i < 0 || i >= r || j >= s){
    cout << "Bounds error!\n";
    exit(1);
  }
  return p[i][j];
}

int main (){
  array a;
  a.put (1,2) = 1;
  a.put (0,0) = 2;
  cout << a.get(0,0)<< '\n' << a.get(1,2) << '\n';
}
