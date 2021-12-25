package task5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;

class TestTask5 {

    Message m1;
    Message m2;
    Calendar cal1 ;

    @BeforeEach
    void SetBeforeEach() {
        m1 = new Message("Some text");

        cal1 = Calendar.getInstance();

        m2 = new Message("Vasya", "Interface", null,
                cal1.getTime().toString(), 1);
    }

    @Test
    void TestCopyObject() throws CloneNotSupportedException{

        m2 = m1.clone();

        assertEquals(m1, m2);

    }

    @Test
    void TestEquals() {

        assertEquals(false, m1.equals(m2));
    }

    @Test
    void TestHashCode() {
        int hash = m1.hashCode() ;
        assertEquals(hash, m1.hashCode());
    }

    @Test
    void TestGetText() {

        assertEquals("Some text", m1.getText());

    }

    @Test
    void TestGetTime() {

        assertEquals(cal1.getTime().toString(), m2.getTime());

    }

    @Test
    void TestGetAuthor() {

        assertEquals("Vasya", m2.getAuthor());

    }

}