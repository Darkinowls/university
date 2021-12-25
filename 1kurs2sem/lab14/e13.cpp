// коли ми заднім числом добавим stl(Standard Template Library)
// тобто пропишемо using namespace std; , тоді можна забрати розширення
// std :: , що явно зменшить кількість коду , але требабути акуртним
// з назвами введеними користувачем , які можуть повторюватися
//приклад :


#include <iostream>

int cout (){
  return 1 ;
}

int main(){
std :: cout << cout() ;
}
