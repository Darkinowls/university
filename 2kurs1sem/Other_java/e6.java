import java.util.Scanner ;
import java.lang.*;

public class e6{

  public static void main(String[] args){

    Scanner scan = new Scanner(System.in);
    System.out.println("Input length of string");
    int len = scan.nextInt();

    if( len <= 2 ){
      System.out.println("Length is 2 or less");
      System.exit(-1) ;
    }


  }
}
