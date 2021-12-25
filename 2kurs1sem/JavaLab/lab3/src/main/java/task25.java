
public class task25 {

    public static String similar(String s1 , String s2 ){

        if (s1.length() > s2.length()) { // s1 має бути меншим
            String temp = s1 ;
            s1 = s2 ;
            s2 = temp ;
        }

        String temp = "" ;

        for (int i = s1.length() ; i > 1 ; i--){ // мінімальна допустима довжина
            for ( int j = 0 ; j < s1.length()  ; j++ )
                for (  int k = 0 ; k < s2.length() ;  k++ )
                    if( s1.regionMatches( true , j , s2 , k , i )) {
                        temp = String.copyValueOf( s1.toCharArray(), j , i );
                        return temp;
                    }

        }
        temp = null ;
        return temp;
    }

    public static String findSubString(String[] args){
        String max = "" ;

        for(int i = 0 ; i < args.length - 1 ; i++){
            if (max == null){
                System.out.println("There isn't mutual substring!");
                break ;
            }
            max = similar (args[i] , args[i+1] ); // знаходимо спільне в двох словах
            args[i+1] = max ;
        }
        System.out.println("Mutual substring : " + max);
        return max ;
    }

    public static void main(String[] args) {

        Out.outArgs( args );

        findSubString( args ) ;

    }
}