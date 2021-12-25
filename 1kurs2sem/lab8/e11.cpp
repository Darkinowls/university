# include <iostream >
using namespace std;
// A base class for various types of vehicles .
class vehicle{

  int num_wheels ;
  int range ;
public :
  vehicle (int w, int r){
  num_wheels = w;
  range = r;
  }
  void showv (){
  cout << " Wheels : " << num_wheels << '\n';
  cout << " Range : " << range << '\n';
  }
};


enum motor {gas , electric , diesel };
class motorized {

  enum motor mtr ;
  public :
  motorized ( enum motor m) {
  mtr = m;
}
  void showm (){

    cout << " Motor : ";
    switch (mtr ){

      case gas : cout << "Gas \n";
      break ;
      case electric : cout << " Electric \n";
      break ;
      case diesel : cout << " Diesel \n";
      break ;
    }
  }
};

///

class road_use {
  int passengers ;
public :
  road_use (int p) {
    passengers = p;
  }
  void showr (){
    cout << " Passengers : " << passengers << '\n';
  }
};

////

enum steering { power , rack_pinion , manual };
class car : public motorized , public road_use , public vehicle{
  enum steering strng ;
public :
  car ( enum steering s, enum motor m, int w, int r, int p) : road_use (p), motorized (m), vehicle (w, r){
    strng = s;
  }

void show (){
  showv ();
  showr ();
  showm ();
  cout << " Steering : ";
  switch ( strng ) {
    case power : cout << " Power \n";
    break ;

    case rack_pinion : cout << " Rack and Pinion\n";
    break ;

    case manual : cout << " Manual \n";
    break ;
    }
  }
};

////

int main () {
  car c(power , gas , 4, 500 , 5);
  c. show ();

}
