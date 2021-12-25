#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <time.h>

enum {
  NPREF = 2 ,
  NHASH = 5 ,
  MAXGEN = 10000
};

typedef struct State State ;
typedef struct Suffix Suffix ;

struct State {
  char *pref[NPREF];
  Suffix *suf ;
  State * next ;
};

struct Suffix{
  char *word ;
  Suffix *next ;
};

  char NONWORD[] = "\n" ;

State *statetab[NHASH];

unsigned int hash (char *s[NPREF]){
  unsigned int h = 0 ;
  unsigned char *p ;
  for (int i = 0; i < NPREF; i++)
    for (p = (unsigned char *)s[i] ; *p != '\0'; p++)
      h = 31*h + *p ;
  return h % NHASH ;
}

State * lookup (char *prefix[NPREF], int create){
  int i ;
  State *sp;
  int h = hash(prefix);
  for (sp = statetab[h]; sp != NULL ; sp = sp -> next ) {
    for ( i = 0 ; i < NPREF ; i++) {
      if ( strcmp ( prefix[i], sp->pref[i] ) != 0 ) {
        break ;
      }
    }
    if ( i == NPREF ) return sp ;
  }
  if (create) {
    sp = (State *) malloc (sizeof(State)) ;
    if ( sp == NULL ) {
      perror("Memory allocation error.");
      exit(1);
    }
    for ( i = 0; i < NPREF ; i++) {
      sp->pref[i] = prefix[i];
    }
    sp->suf = NULL ;
    sp->next = statetab[h];
    statetab[h] = sp ;
  }
  return sp ;
}
void addsuffix (State * sp , char * suffix){
  Suffix *suf;
  suf = (Suffix *)malloc(sizeof(Suffix));
  if ( suf == NULL ) {
    perror ("Memory allocation error.");
    exit(1);
  }
  suf->word = suffix ;
  suf->next = sp->suf ;
  sp->suf = suf ;
}

void add (char * prefix[NPREF], char * suffix){
  State *sp ;
  sp = lookup(prefix, 1);
  addsuffix( sp , suffix );
  memmove(prefix, prefix + 1 , (NPREF-1)* sizeof(prefix[0]));
  prefix[NPREF-1] = suffix ;
}

char * mystrdup (char * s){
  char * t ;
  t = (char*) malloc (strlen(s) + 1 );
  if ( t == NULL ) {
    perror ("Erorr : strdup failed.");
    exit(1);
  }
  strcpy(t,s);
  return t ;
}

void build (char *prefix[NPREF], FILE *f){
  char buf[100] , fmt[10] ;
  sprintf(fmt, "%%%lds", sizeof(buf)-1);
  printf ("fmt=\"%s\"\n", fmt) ;
  while ( fscanf(f, fmt , buf) != EOF ) {
    printf("%s ", buf );
    add(prefix,mystrdup(buf));
  }
  putchar('\n');
}

void generate(int nwords) {
	int orig = 0, copy = 0;
	int ob = 0, cb = 0;
	char check[100];
	FILE *file;
	file = fopen("brooks.txt", "r");
	while(fscanf(file, "%s", check) != EOF) {
		orig++;
		ob += strlen(check)+1;
	}
	State *sp;
	Suffix *suf;
	char *prefix[NPREF], *w;
	int i, nmatch;
	for(i = 0; i < NPREF; i++)
		prefix[i] = NONWORD;
	printf("\n");
	for(i = 0; i < nwords; i++) {
		sp = lookup(prefix, 0);
		nmatch = 0;
		for(suf = sp->suf; suf != NULL; suf = suf->next) {
			if (rand() % ++nmatch == 0) {
				w = suf->word;
			}
		}
		if (strcmp(w, NONWORD) == 0)
			break;
		copy++;
		cb += strlen(w)+1;
		printf("%s ", w);
		memmove(prefix, prefix+1, (NPREF-1)*sizeof(prefix[0]));
		prefix[NPREF-1] = w;
	}
	printf("\n\nWords of original: %d\nWords of generated %d\nBytes of original: %d\nBytes of generated: %d\n",orig, copy, ob, cb);
}


int main() {
  int i , nwords = MAXGEN ;
  char * prefix [NPREF] ;
  for  (i = 0; i < NPREF; i++) {
    prefix[i] = NONWORD ;
  }

  FILE *file;
  file = fopen ("brooks.txt","r");
  if (file) {
    build (prefix,file) ;
    fclose(file);
  }
  add(prefix , NONWORD);
  generate (nwords);
}
