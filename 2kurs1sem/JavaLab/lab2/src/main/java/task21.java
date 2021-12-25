public class task21 {

    public static void main(String[] args){

        int[] a = new int [] { 1 , 2 , 3 , 4 , 5 } ;
        int[] b = new int [] { 5 , 6 , 8 , 8 , 9 , 10 } ;

        findIndex( a , b );
    }
    public static int[] findIndex( int[] a , int[] b){


        int k = (a[0] - a[1]) / (b[0] - b[1]);
        int c = a[0] - b[0];
        int j = 0 ;


        for ( int i = 0 ; i < a.length ; i++ ){
            if( a[i] == k*b[i] + c ){
                b[j++ ] = i ;
                System.out.println("елементи з індиксами "+i);
            }
        }
    return Ihate.IntArray(j , b ) ;
    }
}
