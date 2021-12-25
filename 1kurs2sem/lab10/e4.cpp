#include <iostream>
#include <ctime>
#include <iomanip>
using namespace std ;



  ostream & tdm (ostream& stream ){
    time_t t = time(NULL);
    tm * ltm = localtime(&t);
    stream << ltm->tm_hour << ":" << ltm->tm_min ;
    return stream ;
  }


int main (){

  cout << tdm ;

}
