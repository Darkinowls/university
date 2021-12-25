import java.util.Stack;

public class task5 {

    public static Stack<Character> fillStack(Stack<Character> stk1 ){
        for ( char a:"Привет, i'm 18 years old".toCharArray()) {
            stk1.push(a);
        }
        return stk1;
    }

    public static void main(String[] args){

        Stack<Character> stk1 = new Stack<>();
        fillStack( stk1 );

        Stack<Character> stk2 = new Stack<>();

        int key = 555 ;

        System.out.printf("Encrypted : %n");

        Caesar( key , stk1 , stk2);

        System.out.printf("%nDecrypted : %n");

        Caesar( -key , stk2 , stk1);
    }

    public static Stack<Character> Caesar(int key , Stack<Character> stk1 , Stack<Character> stk2 ){

        while(!stk1.empty()) System.out.print(stk2.push((char)(stk1.pop() + key)));

        System.out.println();

        return stk2 ;
    }
}