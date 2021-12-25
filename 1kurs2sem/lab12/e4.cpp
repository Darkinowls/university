#include <iostream>
#include <typeinfo>
using namespace std ;

template <class c> class input{
c * val ;
public:
  input (char* s , c mi , c ma){
    c temp ;
    cout << s << " between " << mi <<" and " << ma << " > "  ;
    cin >> temp ;
    if (temp >= mi && temp <=  ma){
      val = new c ;
      *val = temp;  // тому що temp повністю стирається коли закінчується scope
    }
  }
  show(){
    if (!val){
      cout << "there are not value!";
      return 0;
    }
    cout << "Value is " << * val << endl ;
  }
};



int main(){
  input <int> obj ("prompt message" , 0 , 100 );
  obj.show();
}
