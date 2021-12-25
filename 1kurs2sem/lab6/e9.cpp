#include <iostream>
#include <cstdio>
#include <ctime>
using namespace std;

class Date{
    int day, mon, year;
    public:
        Date(int d, int m, int y){
            this->day = d;
            this->mon = m;
            this->year = y;
        }
        Date(const char *str){
            sscanf(str, "%d%*c%d%*c%d", &day, &mon, &year);
        }
        Date(time_t time){
            tm* lt = localtime(&time);
            year = (int)(lt->tm_year + 1900);
            mon = (int)(lt->tm_mon + 1 );
            day = (int)(lt->tm_wday-2);
        }
        void show(){
            cout << day << '/' << mon << '/' << year << '\n';
        }
};

int main() {
    Date date(time(0));
    date.show();
    Date date2("19/03/2019");
    date2.show();
    return 0;
}
