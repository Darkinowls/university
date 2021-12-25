import java.util.Scanner;

public class HelloJava2 {

public static void main(String[] args) {

		try{

			Scanner sc = new Scanner(System.in);

			System.out.println("What's your name?");

			String str = sc.next();

	     System.out.println("Glad to see you, " + str);

        }catch(Exception e){

			throw new Error();

		}

    }
}
