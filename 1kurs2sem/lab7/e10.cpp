#include <iostream>
#include <cstdlib>
using namespace std ;

class dynarray {
 int *ptr;
 int size;
public:
 dynarray(int s);
 int &put(int i){
   if (i < 0 || i >= size) {
     exit(0);
   }
   return *(ptr+i);
 }
 int get(int i){
   if (i < 0 || i >= size) {
     exit(0);
   }
   return *(ptr+i);
 }
 void operator =(dynarray &obj){
   int litlsize = (size < obj.size)? size : obj.size ;
   size = litlsize;
   for (int i = 0; i < size ; i++) {
     ptr[i] = obj.get(i);
   }
 }
 ~dynarray(){
   for (int i = 0; i < size; i++) {
     printf("%d ", ptr[i] );
   }
   printf("\n");
   delete [] ptr ;
 }
};

dynarray::dynarray (int s){
  ptr = new int[size = s];
  if (!ptr) {
    printf("AAA\n" );
    exit(-1);
  }
}

int main() {

  dynarray obj1(5) ;

  for (int i = 0; i < 5; i++) {
    obj1.put(i) = i ;
  }

  dynarray obj2(10) ;

  obj2 = obj1 ;

}
