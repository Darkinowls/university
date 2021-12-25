#include <iostream >
using namespace std;


class building {
 int rooms;
 int floors;
 int area ;
public:
 building(int ro, int fl , int ar ) {
 rooms = ro;
 floors = fl;
 area = ar ;
 }
 void showv() {
 cout << "rooms: " << rooms << '\n';
 cout << "floors: " << floors << '\n';
 cout << "area: " << area << '\n';
 }
};

class house : public building {
 int baths ;
 int sleeps ;
 public:
  house(int sl , int ba , int ro , int fl , int ar ):building(ro,fl,ar){
    baths = ba ;
    sleeps = sl ;
  }
 void show() {
 showv();
 cout << "baths: " << baths << '\n';
 cout << "sleeps: " << sleeps << '\n';
 }
};

class office : public building {
 int fires;
 int phones ;
public:
  office(int fi , int ph, int ro , int fl , int ar ):building(ro,fl,ar){
    fires = fi ;
    phones = ph;
  }
 void show() {
 showv();
 cout << "fires: " << fires << '\n';
 cout << "phones: " << phones << '\n';
 }
};

int main() {
 office obo(10 , 50 ,30, 12, 1200);
 house obh(40 , 35  ,30, 12, 1200);
 cout << "office:\n";
 obo.show();
 cout << "\nhouse:\n";
 obh.show();
 return 0;
}
