#include <iostream>
using namespace std ;

class ft_to_cms {
 double feet;
 double cms;
public:
 void set(double f = 1) {
 feet = f;
 cms = f * 30.48;
 }
 friend istream & operator >> (istream & stream , ft_to_cms & ob){
   printf("write foots : ");
   stream >> ob.feet ;
   ob.set(ob.feet);
   return stream ;
 }
 friend ostream & operator << (ostream & stream , ft_to_cms & ob){
   stream <<"it's "<< ob.cms << " cms"<< endl ;
   return stream ;
 }
};

int main (){
  ft_to_cms ob ;

  cin >> ob ;
  cout << ob ;

}
