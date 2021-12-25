
public class task16 {

    public static int time = 0 ;
    public static char[] global = new char [50] ;

    public static void main(String[] args){

        char[] a = new char [] { '\110' , 's' , 'b' , 'd' , 'e' , 'a'};
        char[] b = new char [] { 'b' , 'c' , 'a' };

        findDif( a , b );
    }

    public static void theSame( char[] a , char[] b ){
        for (int i = 0 ; i < a.length ; i++ ){
            boolean same = false ;
            for(int j = 0 ; j < b.length ; j++){
                if(a[i] == b[j]) same = true ;
            }
            if(!same){
                global[time++] = a[i] ;
                System.out.println(a[i]);
            }
        }
    }

    public static char[] findDif ( char[] a , char[] b ){

        theSame ( a , b );
        theSame ( b , a );

    return Ihate.CharArray(time , global) ;
    }
}
