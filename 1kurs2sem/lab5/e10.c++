#include <iostream>
#include <cstdlib>
#include <cstring>
using namespace std ;

typedef struct Nameval Nameval ;
struct Nameval{
  char * name ;
  Nameval *next ;
};

Nameval * newitem( char* name ){
  Nameval *newp;
  newp = new Nameval ;
  newp->name = name ;
  newp->next = NULL ;
  return newp;
}

Nameval * addfront(Nameval *listp ,  Nameval* newp){
  newp->next = listp;
  return newp;
}

Nameval * addend (Nameval * listp , Nameval * newp){
  if (listp == NULL) return newp ;
  Nameval * p ;
  for (p = listp ; p-> next != NULL ; p = p->next);
  p->next = newp ;
  return listp ;
}

Nameval *delitem (Nameval * listp , char * name){
  Nameval *p , * prev ;
  prev = NULL ;
  for ( p = listp; p != NULL ; p = p->next) {
    if (strcmp(name , p->name) == 0 ){
      if (prev == NULL) {
        listp = p->next ;
      }else prev-> next = p->next ;
      delete p ;
      return listp ;
    }
    prev = p ;
  }
  printf ("delitem: %s not in list " , name);
  return NULL;
}

Nameval *copy(Nameval *listp , char * target , char * copier){
  Nameval * p ;
  for ( p = listp; p != NULL ; p = p->next) {
    if (strcmp(p->name , target) == 0) {
      p->name = copier ;
      return listp;
    }
  }
  return listp;
}

Nameval * merg (Nameval *listp , char * name ){
  Nameval * p ;
  for ( p = listp; p != NULL ; p = p->next)
    if (strcmp(p->name , name) == 0)
      for ( p = p->next ; p != NULL ; p = p->next)
        if (strcmp(p->name , name) == 0){
          listp = delitem (listp , name );
          return listp ;
        }
  return listp ;
}

Nameval * split (Nameval * listp , char * name ){
  Nameval * p ;
  for ( p = listp; p != NULL ; p = p->next){
    if (strcmp(p->name , name) == 0) {
      listp = addfront (listp , newitem(name)) ;
      return listp ;
    }
  }
  printf("%s not found!\n", name );
  return listp ;
}

void out (Nameval * listp){
  Nameval * p ;
  for ( p = listp; p-> next != NULL ; p = p->next){
      printf("%s\n", p->name );
  }
  printf("%s\n", p->name );
}

Nameval * after (Nameval * listp , char * name  ){
  Nameval * p ;
  for ( p = listp; p != NULL ; p = p->next){
    if (strcmp(p->name , name) == 0){
      Nameval * temp , *newp ;
      temp = p-> next ;
      newp = newitem( "inserted" ) ;
      p->next = newp ;
      newp->next = temp ;
      return listp ;
    }
  }
    return listp ;
}

int main (){
  Nameval * nvlist = NULL ;
  nvlist = addfront (nvlist , newitem("data1")) ;
  nvlist = addfront (nvlist , newitem("data2")) ;
  nvlist = addfront (nvlist , newitem("data3")) ;
  nvlist = delitem (nvlist , "data3" );
  nvlist = copy (nvlist , "data2" , "data1" );
  nvlist = merg (nvlist , "data1") ;
  nvlist = split (nvlist , "data1");
  nvlist = addfront (nvlist , newitem("data4")) ;
  nvlist = after (nvlist , "data1");
  out (nvlist);
}
