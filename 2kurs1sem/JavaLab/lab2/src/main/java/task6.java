public class task6 {

    public static void main(String[] args) {
        int[] a = new int []{3 , 1 , 2 , 4 , 2 , 6 , 8 , 7 , 9 , 10 } ;
        if(a.length < 3) {
            System.out.print("Error need 3 and more");
        }
        else findMin(a);
    }

    public static int[] findMin(int[] a){

        int j = 0 ;

        System.out.println("So, local mins :");

        for (int i = 1 ; i < a.length - 1   ; i++ ) {
            if(a[i] < a[i+1] && a[i] < a[i-1] ){
                System.out.println("a["+i+"] = " + a[i]);
                a[j++] = a[i] ;
            }
        }

        return Ihate.IntArray( j , a );
    }
}
