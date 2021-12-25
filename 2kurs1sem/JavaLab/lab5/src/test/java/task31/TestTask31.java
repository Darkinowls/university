package task31;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestTask31 {

    Track t1;
    Track t2;

    @BeforeEach
    void set(){
        t1 = new Track(300 , "" , 4 );
        t2 = t1.clone();
    }

    @Test
    void TestSetGetCapacity(){
        t1.setCapacity(7000);
        assertEquals(7000, t1.getCapacity());
    }

    @Test
    void TestSetGetBrand(){
        t1.setBrand("Toyota");
        assertEquals("Toyota", t1.getBrand());
    }

    @Test
    void TestSetGetCylinder(){
        t1.setCylinder(6);
        assertEquals(6, t1.getCylinder());
    }

    @Test
        void TestSetGetPower(){
        t1.setPower(200);
        assertEquals(200, t1.getPower());
    }

    @Test
    void TestEqualToString(){
        assertEquals(true , t1.toString().equals(t2.toString()));
    }

    @Test
    void TestHashCode(){
        assertEquals(t1.hashCode(),t2.hashCode());
    }

}