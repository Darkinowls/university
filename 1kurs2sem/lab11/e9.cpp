#include <iostream>
#include <cstdlib>
using namespace std ;

class list{
  public :
  list *head ;
  list *tail;
  list *next;
  int num ;
  list(){ head = tail = next = NULL ;}
  virtual void store (int i) = 0 ;
  virtual int retrieve () = 0 ;
};

class queue : public list {
  public :
  void store(int i);
  int retrieve();
  void operator + (int i){
    this -> store(i);
  }
  void operator - (int i){
    for (; 0 < i; i--) retrieve();
  }
};

void queue :: store(int  i){
  list *item ;
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

class stack : public list {
  public :
  void store(int i);
  int retrieve();
  void operator + (int i){
    this -> store(i);
  }
  void operator - (int i){
    for (; 0 < i; i--) retrieve();
  }
};

void stack:: store(int i){
  list * item;
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

int main() {
   list *p;
   queue qob;
   stack sob;

   sob + 2 ;
   p = & sob ;

   cout <<  p->retrieve() << endl ;

   qob + 1 ;
   p = & qob ;

   cout <<  p->retrieve() << endl ;

   sob - 1 ;
   p = & sob ;

   cout <<  p->retrieve() << endl ;

   qob - 1 ;
   p = & qob ;

   cout <<  p->retrieve() << endl ;



}
