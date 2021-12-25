#include <iostream>
using namespace std ;

int main(){

  try{

  exception e ;

}
catch(...){
  cerr << "AAAAAAAA!!!!! " ;
  terminate();
}
printf("Fine\n" );




double *p;
try{

p = new double [100000 * 100000];

}
catch(exception){
cerr << "AAAAAAAA!!!!! " ;
terminate();
}
printf("Fine\n" );
}
