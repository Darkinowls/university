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
};

void queue :: store(int  i){
  list *item ;
  item = new queue ;
  if(!item){
    cout << "Allocation error.\n";
    exit(1);
  }
  item-> num = i ;



  if(!head) {
  item->next = new queue ; // память потрібна для майбутніх swapiв
  head = item ; // для першого елемента
  }
  else
  {
    list * p = head;
    int t ;
    for ( ; p->next != NULL ; p = p->next ) {

      if (item->num < p->num ) {

        t = p->num ;
        p->num = item->num ; // swapи
        item->num = t ;

      }
    }
      p->num = item->num ;
      p->next = new queue ;
  }
}

int queue :: retrieve(){
  int i ;
  if(!head){
    cout << "list empty\n";
    return 0;
  }

  i = head -> num ;
  head = head -> next ;

  return i ;

}


int main() {
 list *p;
 queue ob;
  p = & ob ;

  p -> store(2);
  p -> store(1);
  p -> store(3);
  p -> store(6);
  p -> store(5);
  p -> store(4);


  cout << p->  retrieve() << endl ;
  cout << p->  retrieve() << endl ;
  cout << p->  retrieve() << endl ;
  cout << p->  retrieve() << endl ;
  cout << p->  retrieve() << endl ;
  cout << p->  retrieve() << endl ;


}
