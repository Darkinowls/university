 #include <iostream>
 #include <new>
 using namespace std ;


int  fun() {

  double * p;

  p = new double[100000000*1000000000];


}

 int main(){

   fun() ;

    cout << "unreadable!" << '\n';


 }
 // в мене  при невдалій спробі виділити пам'яті автоматично спрацьовує terminate
