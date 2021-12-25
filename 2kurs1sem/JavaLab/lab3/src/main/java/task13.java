
public class task13 {

    public static char[] changer ( char[] str , String abcStr , String keyStr ){

        char[] abc = abcStr.toCharArray();
        char[] key = keyStr.toCharArray();

        for(int j = 0 ; j < str.length ; j++){
            for(int i = 0 ; i < abc.length ; i++){

                if ( str[j] == abc[i]  ){
                    str[j] = key[i] ;
                    break;
                }

                if ( str[j] == Character.toUpperCase(abc[i])  ){
                    str[j] = Character.toUpperCase(key[i]) ;
                    break;
                }
            }
            System.out.print(str[j]) ;
        }

        System.out.println();
        return str ;
    }

    public static void main(String[] args){

        String abcStr = "abcdefghijklmnopqrstuvwxyz" ;
        String keyStr = "zyxcbawvutsrqponmlkjihgfed" ;

        String myStr = "I'm going to feel";
        char[] str = myStr.toCharArray();

        System.out.printf("Encrypted : %n");
        changer( str , abcStr , keyStr );
        System.out.printf("Decrypted : %n");
        changer( str , keyStr , abcStr );

    }
}
