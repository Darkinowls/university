import org.junit.Test;
import java.io.IOException;
import java.util.*;

import static org.junit.Assert.*;

public class taskTest {

    @Test
    public void Test25() throws IOException {
        task25 test = new task25();

        ArrayList<String> actuall = test.toAlbum(test.Gallery(new HashMap<>(5)) , test.FillTree(new TreeSet<>()));

        ArrayList<String> expected = new ArrayList<>();
        expected.add("Dali");

        assertEquals( expected.toString() , actuall.toString() );

    }

    @Test
    public void Test31() {
        task31 test = new task31();

        TreeMap<Integer, task31.Article> actuall = test.heshCheck( test.Shop(new TreeMap<>()) );

        TreeMap<Integer, task31.Article> expected = test.Shop(new TreeMap<>()) ;
        expected.remove(5);

        assertEquals( expected.get(5) , actuall.get(5) );

    }
    @Test
    public void Test5() {
        task5 test = new task5();


        String actuall = test.Caesar( -15 ,
                test.Caesar( 15 , test.fillStack(new Stack<>()) , new Stack<>() ),
                new Stack<>() ).toString();

        String expected = test.fillStack(new Stack<>()).toString();

        assertEquals( expected , actuall );

    }

    @Test
    public void Test13() {
        task13 test = new task13();

        ArrayList<Character> abc = new ArrayList<>();
        ArrayList<Character> key = new ArrayList<>();

        test.createAbc(abc, key);

        String actuall = test.changer(
                test.setStr( new ArrayList<>() ,"S'o umsnu hm wvvp".toCharArray()) , key , abc).toString();

        String expected = test.setStr( new ArrayList<>() ,"I'm going to feel".toCharArray()).toString() ;

        assertEquals( expected , actuall );

    }
}