import java.util.ArrayList;
import java.util.Collections;

public class Main {


    public static ArrayList<Integer> analysis(String[] str) {

        ArrayList<Integer> intArr = new ArrayList<>();

        for (int i = 0; i < str.length; i++) {
            if (str[i].matches("^[-,+]?\\d+$")) {
                intArr.add(Integer.parseInt(str[i]));
            }
        }

        return intArr;

    }


    public static void out(String[] str, ArrayList<Integer> intArr) {

        if(str.length != 0){

            System.out.println("Number of input strings : " + str.length );
            System.out.print( "These strings : ");

            for (int i = 0; i < str.length; i++) {
                System.out.print("\""+ str[i] + "\", ");
            }

            System.out.println("\b\b.");

            if(intArr.size() != 0){

                System.out.println("Number of input integers : " + intArr.size());
                System.out.println("The biggest integer : " + Collections.max(intArr));

            }
            else System.out.println("There are no numbers in the input strings !");

        }else System.out.println("There are no strings!");

    }


    public static void main(String[] args) {

        out ( args , analysis(args) );

    }
}
