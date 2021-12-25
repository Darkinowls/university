import static java.lang.reflect.Array.getChar;

public class task31 {

    public static String Sort(String[] args) {

        String temp = " " ;
        for(int j = 0 ; j < args.length - 1 ; j++ )
            for (int i = 0 ; i < args.length - 1 ; i++){

                if( (int)Character.toLowerCase(getChar( args[i].toCharArray() ,0 )) - (int)Character.toLowerCase(getChar( args[i+1].toCharArray() ,0 )) > 0 ){
                    temp = args[i] ;
                    args[i] = args[i+1];
                    args[i+1] = temp ;
                }
            }
        System.out.println("Sorted : ");
        Out.outArgs(args) ;
        return args[0] ;
    }

    public static void main(String[] args) {

        Out.outArgs(args) ;

        Sort ( args ) ;

    }
}
