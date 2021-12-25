import org.junit.Test;
import static org.junit.Assert.*;

public class taskTest {

    @Test
    public void task5test(){
        task5 tester = new task5() ;
        char [] actuall = tester.Caesar( -13 , "HellOo there, I'm 18 !".toCharArray() , true) ;
        char [] expected = "UryyBb gurer, V'z 96 !".toCharArray();
        assertArrayEquals( expected , actuall );
    }

    @Test
    public void task13test(){
        task13 tester = new task13();
        char[] actuall = tester.changer ("I'm going to feel".toCharArray() , "abcdefghijklmnopqrstuvwxyz" , "zyxcbawvutsrqponmlkjihgfed" );
        char[] expected = "U'q woupw jo abbr".toCharArray() ;
        assertArrayEquals( expected , actuall );
    }

    @Test
    public void task25test(){
        task25 tester = new task25();
        String [] three = {"Second", "section" , "Tesec"  } ;
        String actuall = tester.findSubString( three );
        String expected = "Sec"  ;
        assertEquals( expected , actuall );
    }

    @Test
    public void task31test(){
        task31 tester = new task31();
        String [] three = {"wrestler" , "Big", "My"  , "Fellow "   } ;
        String actuall = tester.Sort( three );
        String expected = "Big"  ;
        assertEquals( expected , actuall );
    }

}