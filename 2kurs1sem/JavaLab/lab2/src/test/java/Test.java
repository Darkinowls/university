import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class taskTest {

    @Test
    void task6test(){
        task6  tasktest = new task6() ;
        int [] actuall = tasktest.findMin( new int[] { 2 , 1 , 10 , 7 , 8 } ) ;
        int [] expected = new int[] { 1, 7 } ;
        assertArrayEquals( expected , actuall );
    }

    @Test
    void task11test(){
        task11 tasktest = new task11();
        int[] actuall = tasktest.findRange( 5 , 10 );
        int[] expected = new int[] {3 , 1 , 2 , 4 };
        assertArrayEquals( expected , actuall );

    }

    @Test
    void task16test(){
        task16 tasktest = new task16();
        char[] actuall = tasktest.findDif(new char [] { 'a' , 'b' , 'd' , 'e'}, new char [] { 'b' , 'c' , 'a' } );
        char[] expected = new char[] {'d' , 'e' , 'c' };
        assertArrayEquals( expected , actuall );

    }

    @Test
    void task21test(){
        task21 tasktest = new task21();
        int[] actuall = tasktest.findIndex(new int [] { 1 , 2 , 3 , 4 , 5 } , new int [] { 5 , 6 , 7 , 8 , 9 , 10 });
        int[] expected = new int[] { 0 , 1 , 2 , 3 , 4 };
        assertArrayEquals( expected , actuall );

    }
    @Test
    void task25test(){
        task25 tasktest = new task25();
        int actuall = tasktest.findDay(350 , true);
        task25.monthes expected = new task25.monthes ("dec", 15);
        assertEquals( expected.num ,  actuall );
    }
}