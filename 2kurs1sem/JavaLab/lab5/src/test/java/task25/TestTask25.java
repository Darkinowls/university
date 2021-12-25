package task25;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestTask25 {

    Rational r1;
    Rational r2 ;

    @BeforeEach
    void set(){
        r1 = new Rational(new double[]{1,2});
        r1.setDividerValues(new double[]{1, 2, 3});
        r2 = r1.clone();
    }

    @Test
    void TestGetAndSetDividerValues() {

        assertArrayEquals(new double[]{1, 2, 3}, r1.getDividerValues());
    }

    @Test
    void TestGetDividerLength(){
        assertEquals(3,r1.getDividerLength());
    }

    @Test
    void TestGetValues(){
        assertArrayEquals(new double[]{1,2} , r1.getValues());
    }

    @Test
    void TestGetLength(){
        assertEquals(2 , r1.getLength());
    }

    @Test
    void TestEquals(){
        assertEquals(r2 , r1);
    }

    @Test
    void TestHashCode(){
        assertEquals(r2.hashCode() , r1.hashCode());
    }

}