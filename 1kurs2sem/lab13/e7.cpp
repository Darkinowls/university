#include <iostream>
#include <cstdlib>
using namespace std ;

class DataStruct{
  public :
  DataStruct *head ;
  DataStruct *tail;
  DataStruct *next;
  int num ;
  DataStruct(){ head = tail = next = NULL ;}
  virtual void store (int i) = 0 ;
  virtual int retrieve () = 0 ;
};

class queue : public DataStruct {
  public :
  void store(int i);
  int retrieve();
};

void queue :: store(int  i){
  DataStruct *item ;
  item = new queue ;
  if(!item){
    cout << "Allocation error.\n";
    exit(1);
  }
  item->num = i ;

  if(tail) {tail->next = item  ;}

  tail = item ;

  if(!head)head = tail ;
}

int queue :: retrieve(){
  int i ;
  if(!head){
    return 0;
  }

  i = head -> num ;
  head = head -> next ;
  return i ;
}

class stack : public DataStruct {
  public :
  void store(int i);
  int retrieve();

};

void stack:: store(int i){
  DataStruct * item;
  item = new stack ;
  if(!item){
    cout << "Allocation error\n";
    exit(1);
  }
  item-> num = i;
  if(head) item ->next = head ;
  head = item ;
  if(!tail) tail = head ;
}

int stack :: retrieve(){
  int i ;
  if(!head){
    return 0 ;
  }
  i = head ->num ;
  head = head ->next ;
  return i ;
}

DataStruct * DataStructoryFactory( char what ) {
  if (what == 's') return new stack ;
  else if (what == 'q' ) return new stack ;
  return NULL ;

}

int main() {
   DataStruct *p;

   p =  DataStructoryFactory( 's' );

   p->store(1);
   cout << p->retrieve();





}
