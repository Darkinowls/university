package task13;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestTask13 {

    Quadrant o1;
    Quadrant o2;

    @BeforeEach
    void set() {
        o1 = new Quadrant(1);
        o2 = new Quadrant(10);
    }

    @Test
    void testSetGetPerimeter() {
        o1.setPerimeter(10);
        assertEquals(10, o1.getPerimeter());
    }

    @Test
    void testSetGetSquare() {
        o1.setSquare(10);
        assertEquals(10, o1.getSquare());
    }

    @Test
    void testCalculationOfPerimeter() {
        assertEquals(40, o2.getPerimeter());
    }

    @Test
    void testCalculationOfPSquare() {
        assertEquals(100, o2.getSquare());
    }

    @Test
    void testEquals() {
        assertEquals(false, o2.equals(o1));
    }

    @Test
    void testHash() {
        assertEquals(false, o2.hashCode() == o1.hashCode());
    }

}