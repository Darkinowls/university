#include <iostream>
#include <math.h>
#include <stdlib.h>
#include <time.h>
#include <iomanip>

#define LOWER 0
#define UPPER 55

using namespace std;

class MyFunctionClass{
    int a, b, x1 , x2 ;
    float dx  ;
    int size ;
    pair <float,float> values []; // first = x , second = y
public:

    void setParametrs(int a = 10, int b = 9, int x1 = 0, int x2 = 3, float dx=0.1){
        this->a = a ;
        this->b = b ;
        this->x1 = x1 ;
        this->x2 = x2 ;
        this->dx = dx ;
        size = (int)((x2 - x1)/dx + 2) ;
    }

    void CalculateAll(){

        cout << "\nCalculateAll : " << '\n';

        float i = x1 ;

        for ( int j = 0 ; j < size ; i = i + dx , j++ ) {

            values[j].first = i ;

            if( i <= 1) values[j].second = (pow(i,2))*a-b;
            else values[j].second = a/(i+b) ;

            printf("f(%0.1f) = %.3f\n", values[j].first , values[j].second );

        }
    }

    void ReadPar(){
        printf("\na =") ;
        scanf("%d", &a );

        printf("b =" );
        scanf("%d", &b);

        printf("x1 =" );
        scanf("%d", &x1);

        printf("x2 =" );
        scanf("%d", &x2 );

        printf("dx =" );
        scanf("%f", &dx );

        size = (int)((x2 - x1)/dx + 2);
    }

    void tab(){

        enum { lineV = 186 ,leftTop = 201 ,lineH = 205 ,topT = 203 ,botT = 202 ,cross = 206 ,
            rightTop = 187 ,leftT = 204 ,rightT = 185 ,leftBot = 200 , rightBot = 188};

        {
            printf("%c",  leftTop );
            for (int i = 0; i < 20; i++) {
                if (i == 3 || i == 9)printf("%c",  topT );
                else printf("%c", lineH);
            }
            printf("%c\n",  rightTop );
        }


        printf("%-2c%s%2c%3s%3c%7s%4c\n", lineV, "N", lineV, "x", lineV, "f(x)",lineV);

        for (int index = 0 ; index < size ; index++) {
        printf("%c",leftT);

            for (int i = 0; i < 20 ; i++) {
                if (i == 3 || i == 9 )printf("%c",cross);
                else printf("%c",lineH);
            }
            printf("%c\n",rightT);

            printf("%c% -3.f%c%- 5.1f%c%- 10.5f%c\n",
                    lineV , (float)index , lineV , values[index].first, lineV ,values[index].second, lineV );

        }

        {
            printf("%c",  leftBot);
            for (int i = 0; i < 20; i++) {
                if (i == 3 || i == 9)printf("%c",  botT);
                else printf("%c", lineH);
            }
            printf("%c\n", rightBot );
        }

    }

    float getRandomFloat( int min , int max ){

        float r;

        for (;;) {
            r = rand() - rand();
            if(max*1000  > r && r > min*1000 )return r/1000 ;
        }
    }

    pair<float,float> * makeRandomArray(float *s1 , float *s2 ,pair<float,float> *rnd){

        for (int i = 0; i <= size ; i = i + 2) {
            *s1 += values[i].second;
            if(*s2 < values[i].second) *s2 = values[i].second ;
        }

        rnd = (pair<float,float>*) malloc (size * sizeof(pair<float,float>));

        int max ;
        int min ;

        if(*s1 > *s2){
            max = *s1 ; min = *s2 ;
        }else max = *s2 ; min = *s1 ;

        srand(time(NULL));

        float x = 0;
        dx = 0.01 * ((*s1+*s2)/2) ;

        for (int i = 0; i < size ; i++) {
            rnd[i].first = x ;
            rnd[i].second = getRandomFloat(min , max) ;
            x = x + dx ;
        }

    return rnd ;

    }

    void getFunctionsValues(float s1 , float s2 ,pair<float,float> *rnd){

        cout << endl  <<"S1 = " <<s1<< ", S2 = " << s2 << endl << endl  ;

        for (int i = 0; i < size; ++i) {
            values[i].first = rnd[i].first ;
            values[i].second = rnd[i].second ;
        }
    }

    pair<float,float> * findLinear( int lower , int upper){

        pair<float,float> * linearArray ;
        linearArray = (pair<float,float>*) malloc (size * sizeof(pair<float,float>));

        float maxValue = values[0].second;
        float minValue = values[0].second;

        for (int i = 0; i < size; ++i) {
            if(maxValue < values[i].second) maxValue = values[i].second;
            if(minValue > values[i].second) minValue = values[i].second;
        }

        for (int i = 0; i < size; ++i) {
            linearArray[i].first = values[i].first ;
            linearArray[i].second = (int) (lower + (values[i].second - minValue )*
                                                    (upper-lower)/(maxValue - minValue));
        }
        
        return linearArray;
    }

    void Print(int lower ,int upper ){
        for (int i = 0; i < size ; ++i) {
            printf("%-4.1f",values[i].first ) ;
            for (int j = 0; j < values[i].second; ++j) {
                printf("%c" , 0xDD );
            }
            printf("\n");
        }

        cout << setw(5) << (char)0xDD ;
        cout << setw((upper + lower)/2) << (char)0xDD ;
        cout << setw((upper + lower)/2) << (char)0xDD << endl ;

        cout << setw(5) << lower ;
        cout << setw((upper + lower)/2) << (upper + lower)/2 ;
        cout << setw((upper + lower)/2)<< upper << endl ;

    }

};

int main() {

    MyFunctionClass func1 ;

    func1.setParametrs();

    func1.CalculateAll();

    func1.tab();

    pair<float,float> *rnd ;

    float * s1 = new float (0) ;
    float * s2 = new float (-100);

    rnd = func1.makeRandomArray(s1, s2, rnd) ;

    func1.getFunctionsValues(*s1, *s2, rnd);

    func1.tab();

    delete rnd , s1 , s2 ;

    func1.setParametrs(9 , 8 , 0 , 3 , 0.2) ;

    func1.CalculateAll();

    func1.tab();

    func1.ReadPar();

    func1.CalculateAll();

    func1.tab();

    pair<float,float> *LinearA ;

    LinearA = func1.findLinear(LOWER , UPPER);

    func1.getFunctionsValues(LOWER , UPPER, LinearA);

    func1.Print(LOWER , UPPER);


    delete LinearA ;
    return 0;
}

