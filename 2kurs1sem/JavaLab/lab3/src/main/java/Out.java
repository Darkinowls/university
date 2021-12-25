public class Out {
    public static void outArgs(String[] args){
        System.out.println( "There are " + args.length + " arguments : ");
        for (int i = 0; i < args.length; i++) System.out.println( args[i] );

        System.out.println();

    }
}
