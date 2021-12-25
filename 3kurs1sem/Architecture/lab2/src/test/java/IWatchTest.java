import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project.IWatch;
import project.Main;
import project.MyTime;
import project.ProxyTime;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import static org.junit.Assume.assumeThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.matchers.JUnitMatchers.hasItems;

class IWatchTest {

    private IWatch watch;

    @BeforeEach
    void Init() throws Exception {
        watch = new MyTime(2006, 3, 2, 12, 30);
    }

    @Test
    void testToStringEqual() {
        assertEquals("12:30 2.April.2006", watch.toString());
    }

    @Test
    void testToStringNotEqual() {
        assertNotEquals("12:40 5.April.2001", watch.toString());
    }

    @Test
    void setHour() { //negative
        Exception exception = assertThrows(Exception.class, () -> watch.setHour(30));

        String expected = "Hour has to be within 0 and 23 ";
        String actual = exception.getMessage();

        assertEquals(expected, actual);
    }

    @Test
    void setMinute() throws Exception { //negative
        IWatch temp = new MyTime();
        Exception exception = assertThrows(Exception.class, () -> temp.setMinute(-1000000));

        String expected = "Minute has to be within 0 and 59 ";
        String actual = exception.getMessage();

        assertTrue(actual.contains(expected));
    }

    @Test
    void setYear1() { //negative
        assertThat(assertThrows(Exception.class, () -> watch.setYear(-10)), is(Exception.class));
    }

    @Test
    void setYear2() {
        assertDoesNotThrow(() -> watch.setYear(10));
    }


    @Test
    void setMonth1() {
        assertThrows(Exception.class, () -> watch.setMonth(-1000000));
    }

    @Test
    void setMonth2() {
        assertThat(assertThrows(Exception.class, () -> watch.setMonth(-1000000)).getMessage(),
                is("project.Month has to be within 1 and 12"));
    }

    @Test
    void setDayIgnored() { //Ignored
        assumeThat(assertThrows(Exception.class, () -> watch.setDay(-2)).getMessage(),
                is("AAAAAAAAAAAAAAAAAAAAAAAAAAAAA"));
    }

    @Test
    void setDay() {
        assumeThat(assertThrows(Exception.class, () -> watch.setDay(-2)), is(Exception.class));
    }

    @Test
    void getHour() throws Exception {
        watch.setHour(13);
        assertEquals(13, watch.getHour());
    }

    @Test
    void getMinute() throws Exception {
        watch.setMinute(30);
        assertThat(30, is(watch.getMinute()));
    }

    @Test
    void getYear() throws Exception {
        watch.setYear(1000);
        assertThat(1000, equalTo(watch.getYear()));
    }

    @Test
    void getMonth() throws Exception {
        IWatch clone = watch;
        watch.setMonth(4);
        assertSame(clone, watch); // link on a same object
    }

    @Test
    void getDay() throws Exception {
        watch.setDay(10);
        List<Integer> list = Arrays.asList(watch.getDay(), watch.getDay() + 1);
        assertThat(list, hasItems(10, 11));
    }

    @Test
    void proxyPositive() {
        IWatch proxyTime = new ProxyTime(watch).getProxy();
        assertThat("April", is(proxyTime.getMonth()));
    }

    @Test
    void proxyNegative() {
        IWatch proxyTime = new ProxyTime(watch).getProxy();
        assertThrows(Exception.class, () -> proxyTime.setMonth(3));
    }


    @Test
    void mainTest() {
        String args[] = {""};
        assertThrows(Exception.class, () -> Main.main(args));
    }

    @Test
    void timeoutTest() {
        assertTimeout(Duration.ofMillis(3000), () -> Thread.sleep(100));
    }



}