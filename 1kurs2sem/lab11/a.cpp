#include <iostream>
#include <cstdlib>
using namespace std ;

class list{
  public :
  list *next ;
  int num ;
};


int main(){
  list * head ;
  head = new list ;
  head->num = 5 ;

  head -> next = new list ;
  head -> next-> num = 10 ;
  head -> next -> next = NULL;

  list * p = head ;

  for (; p!= NULL ; p = p->next ) {
    printf("d\n");
  }


}
