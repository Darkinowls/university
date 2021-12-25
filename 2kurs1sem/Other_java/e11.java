import java.util.Scanner ;
import java.lang.*;

public class e11{
  public static void main(String[] str){


    int min = Integer.parseInt(str[0]);
    int max = Integer.parseInt(str[1]);

    if(min > max){
      int temp = min ;
      min = max ;
      max = temp ;
    }

    Scanner scan = new Scanner(System.in);
    System.out.println("Input length of string");
    int len = scan.nextInt();

    if( len <= 2 ){
      System.out.println("Length is 2 or less");
      System.exit(-1) ;
    }

    int[] a = new int [len] ;
    for (int size = len  ; size > 0 ; size-- ) {
      System.out.print("Input " + (size-1) + "th element : " );
      a[size-1] = scan.nextInt();
    }

    for ( int i = 0 ; i < len ; i++ ) {
      if(a[i] < min || a[i] > max) System.out.println("a["+i+"] = " + a[i]);
    }


  }
}
