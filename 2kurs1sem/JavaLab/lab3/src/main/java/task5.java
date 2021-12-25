import static java.lang.Character.isLetter;

public class task5 {

    public static void main(String[] args){

        String str = "HellOo there, I'm 18 !";

        char[] input = str.toCharArray();

        int key = -13 ;

        System.out.printf("Encrypted : %n");

        Caesar( key , input , false );

        System.out.printf("%nDecrypted : %n");

        Caesar( -key , input , false );
    }

    public static char[] Caesar(int key , char[] input , boolean bool ){

        key = key % 26 ;

        for(int i = 0 ; i < input.length ; i++){

            if(isLetter(input[i])) {
                if (input[i] + key < 'a' && Character.isLowerCase(input[i]))
                    input[i] = (char) (input[i] + key - 'a' + 'z' + 1);

                else if (input[i] + key > 'z')
                    input[i] = (char) (input[i] + key + 'a' - 'z' - 1);

                else if (input[i] + key < 'A')
                    input[i] = (char) (input[i] + key - 'A' + 'Z' + 1);

                else if (input[i] + key > 'Z' && Character.isUpperCase(input[i]))
                    input[i] = (char) (input[i] + key + 'A' - 'Z' - 1);

                else input[i] += key;
            }

            withNum(key , input , bool , i ) ;
        }
        System.out.println();
        return input ;
    }

    public static void  withNum(int key ,char[] input , boolean bool , int i){
        int numkey = key % 11 ;
        if (bool){
            if(Character.isDigit(input[i])&& input[i] + numkey > '9' )
                input[i] = (char)( input[i] + numkey - '9'  + '0' - 1 ) ;

            else if(Character.isDigit(input[i])&& input[i] + numkey < '0' )
                input[i] = (char)( input[i] + numkey + '9'  - '0' + 1 ) ;

            else if(Character.isDigit(input[i])) input[i] += numkey ;

        }
        System.out.print(input[i]);
    }
}

