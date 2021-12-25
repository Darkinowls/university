import java.lang.reflect.Array;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeMap;

public class task31 {

    public static class Article{
        public String name ;
        public float price ;

        public Article( String n , double p ){
            name = n ;
            price = (float)p ;
        }

    }

    public static TreeMap  <Integer, Article> Shop(TreeMap  <Integer, Article> list){

        list.put(1 , new Article( "Milk" , 10.2 ));
        list.put(2 , new Article( "Latte" , 15.7 ));
        list.put(3 , new Article( "Ring" , 100.5 ));
        list.put(4 , new Article( "Bread" , 5.1 ));
        list.put(5 , new Article( "Milk" , 500.2 ));

        return list ;
    }

    public static void ShowList(TreeMap  <Integer, Article> list){

        for (int index : list.keySet() ) {
            System.out.println( index + "." + list.get(index).name + " - " +list.get(index).price);
        }
    }

    public static void ChangePrice(TreeMap  <Integer, Article> list){

        System.out.println("\n('0' to quit )Type index of good you want to change its price : ");

        Scanner scan2 = new Scanner(System.in);
        Scanner scan = new Scanner(System.in);

        int index = scan.nextInt();

        for ( ;index >= Collections.min(list.keySet()) && index <= Collections.max(list.keySet()) ; ){

         System.out.println(index + "."+ list.get(index).name + " - " + list.get(index).price);
         System.out.println("Type new price : ");

         list.get(index).price = scan2.nextFloat(); // use ',' not '.'
         System.out.println(index + "."+ list.get(index).name + " - " + list.get(index).price + "\n");


         System.out.println("('0' to quit )Type index of good you want to change its price : ");
         index = scan.nextInt();

         }
    }

    public static TreeMap  <Integer, Article> heshCheck(TreeMap  <Integer, Article> list){

        HashSet<String> hesh = new HashSet<>();

        boolean isUnique  ;

        for (int index:list.keySet()) {
            isUnique = hesh.add(list.get(index).name);
            if(!isUnique){
                System.out.println("\"" + list.remove(index).name + "\"" + " is not an unique good.\n" );
            }

        }
        return list ;
    }

    public static void main(String [] args){

        TreeMap  <Integer, Article> list = new TreeMap<>();

        Shop(list);

        ShowList(list);

        ChangePrice(list);

        heshCheck(list);

        ShowList(list);

    }
}
