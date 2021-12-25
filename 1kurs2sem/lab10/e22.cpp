#include <iostream>
#include <fstream>
using namespace std;

int SIZE = 20;

class stack{
    ifstream In;
    ofstream Out;
    int size;
    public:
    stack(){size = 0;}
    void InOpen(){In.open("text.txt", ios::in | ios::binary);}
    void OutOpen(){Out.open("text.txt", ios::out | ios::binary);}
    void OutClose(){Out.close();}
    void InClose(){In.close();}

    char pop(){

        In.seekg(size - 1, ios::beg);
        char temp;
        In.get(temp);
        size--;
        return temp;
    }
    void push(char c){

        Out.seekp(size, ios::beg);
        Out.put(c);
        size++;
    }
  };

    int main(){
    stack ob;
    ob.OutOpen();
    for (int i = 0; i < 26; i++)
    {
        ob.push((char)(65+i));
    }
    ob.OutClose();
    ob.InOpen();
    for (int i = 0; i < 26; i++)
    {
        cout << ob.pop() << ' ';
    }
    ob.InClose();
  }
