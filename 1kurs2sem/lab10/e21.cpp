
#include <iostream>
#include <fstream>
#include <cstring>
using namespace std;
#define SIZE 40

class inventory {
 char item[SIZE]; // name of item
 int onhand; // number on hand
 double cost; // cost of item
public:
 inventory(char *i, int o, double c) {
 strcpy(item, i);
 onhand = o;
 cost = c;
 }

 store(fstream &stream);
 friend ostream &operator <<(ostream &stream, inventory obj);
 friend istream &operator >>(istream &stream, inventory &obj);
};

ostream &operator <<(ostream &stream, inventory obj) {
 stream << obj.item << ": " << obj.onhand;
 stream << " on hand at $" << obj.cost << '\n';
 return stream;
}

istream &operator >>(istream &stream, inventory &obj) {
 cout << "Enter item name: ";
 stream >> obj.item;
 cout << "Enter number on hand: ";
 stream >> obj.onhand;
 cout << "Enter cost: ";
 stream >> obj.cost;
 return stream ;
}

inventory::store(fstream &stream) {
	stream << item << ' ' << onhand;
	stream << ' ' << cost << "\r\n";

}


int main(){
  inventory ob1("holod" , 12  , 40.5 ) , ob2(" " , 0 , 0);

  cin >> ob2 ;

  fstream f ("e21.txt");

  ob1.store(f);
	ob2.store(f);
	cout <<  ob1 << ob2;



}
