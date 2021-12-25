import java.util.ArrayList;

import static java.lang.Character.*;

public class task13 {

    public static void createAbc(ArrayList<Character> abc , ArrayList<Character> key){
        char[] abcStr = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char[] keyStr = "zbyxvwutsrqponmlkjihgfedca".toCharArray();

        for (int i = 0 ; i < 26 ; i++) {

            abc.add(abcStr[i]);
            key.add(keyStr[i]);

        }
    }

    public static ArrayList<Character> setStr(ArrayList<Character> list , char[] str ){

        for (char ch: str) {
            list.add(ch);
        }

        return list;
    }

    public static ArrayList<Character> changer ( ArrayList<Character> str , ArrayList<Character> abc , ArrayList<Character> key ) {


        for ( int index, i = 0 ; i < str.size() ; i++) {

            if(!isLetter(str.get(i))) ;
            else if(isLowerCase(str.get(i))) {

                index = abc.indexOf(str.get(i));
                str.set(i ,key.get(index));

            }else if(isUpperCase(str.get(i))){
                index = abc.indexOf(toLowerCase(str.get(i)));
                str.set(i ,toUpperCase(key.get(index)) );

            }
            System.out.print(str.get(i));
        }

        return str;
    }

    public static void main(String[] args){

        ArrayList<Character> abc = new ArrayList<>();
        ArrayList<Character> key = new ArrayList<>();

        createAbc(abc, key );

        ArrayList<Character> str = new ArrayList<>();

        setStr( str , "I'm going to feel".toCharArray() );


        System.out.print("Encrypted : \n");
        changer( str , abc , key );

        System.out.print("\nDecrypted : \n");
        changer( str , key , abc );

    }
}