#include <iostream>
using namespace std ;

template <class cl>
class coord{
  cl x;
  cl y;
public:
  coord (cl i = 0 ,cl j = 0 ){
    x = i ;
    y = j ;
    cout << "In" << endl ;
  }

  get_xy(cl & i , cl & j){
    i = x ;
    j = y ;
  }
  coord operator + ( coord obj); // краще зразу в класі прописувати
};

template <class cl>
coord<cl> coord<cl> :: operator +(coord obj){
  coord temp ;
  temp.x = x + obj.x ;
  temp.y = y + obj.y ;
  return temp ;
}

int main(){
  coord <int> obj(10,10);

  obj = obj + obj ;
  int x ,y ;

  obj.get_xy(x,y);
  cout << x << y << endl ;

  coord <char> obj_ch('a','b');
  string a ;

  obj_ch.get_xy(a[0],a[1]);
  cout << a[0] << a[1] ;

}
