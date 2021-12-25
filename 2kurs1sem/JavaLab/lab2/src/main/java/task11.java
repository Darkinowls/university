import java.lang.*;

public class task11 {
    public static void main(String[] args){

        int min = Integer.parseInt(args[0]);
        int max = Integer.parseInt(args[1]);

        if(min > max){
            int temp = min ;
            min = max ;
            max = temp ;
        }

        findRange(min , max ) ;
    }
    public static int[] findRange(int min , int max){

        int[] a = new int []{3 , 1 , 2 , 4 , 5 , 6 , 8 , 7 , 9 , 10} ;
        int j = 0;

        for ( int i = 0 ; i < a.length ; i++ ) {
            if(a[i] < min || a[i] > max){
                System.out.println("a["+i+"] = " + a[i]);
                a[j++] = a[i] ;
            }
        }
    return Ihate.IntArray (j , a ) ;
    }
}
