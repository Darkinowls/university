import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project.Month;
import project.controller.Controller;
import project.interfaces.IWatch;
import project.model.MyTime;
import project.view.ViewBirth;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


class MockitoTest {

    private IWatch watch = mock(MyTime.class);


    MockitoTest() throws Exception {
        Controller.setView(new ViewBirth());
        Controller.setModel(watch);
    }


    @Test
    void neverMonth() throws Exception {
        verify(watch, never()).getMonth();
    }

    @Test
    void timeMonth() throws Exception {
        Controller.getModel().getMonth();
        verify(watch, times(1)).getMonth();
    }

    @Test
    void timesMonth() throws Exception {
        Controller.getModel().getMonth();
        Controller.getModel().getMonth();
        verify(watch, times(2)).getMonth();
        verify(watch, atLeast(1)).getMonth();
        verify(watch, atMost(10)).getMonth();
    }


    @Test
    void setHour() throws Exception {
        Controller.getModel().setHour(10);
        verify(watch).setHour(10);
        assertEquals(0, watch.getHour());
    }

    @Test
    void setHourAny() throws Exception {
        Controller.getModel().setHour(10);
        verify(watch).setHour(anyInt());
    }


    @Test
    void whenYear() throws Exception {
        when(Controller.getModel().getYear()).thenReturn(2002); // set return for method
        assertEquals(watch.getYear(), 2002);
    }

    @Test
    void thenAndThenYear() throws Exception {
        when(Controller.getModel().getYear()).thenReturn(2002).thenReturn(2000);
        Controller.getModel().getYear();
        assertEquals(watch.getYear(), 2000);
    }


    @Test
    void whenAddDays() throws Exception {
        when(Controller.getModel().addDays(40, 10)).thenReturn(19);
        assertEquals((40 + 10) % 31, watch.addDays(40, 10));
    }

    @Test
    void whenAddDays_few() throws Exception {
        when(Controller.getModel().addDays(40, 10)).thenReturn(19);
        when(Controller.getModel().addDays(5, 3)).thenReturn(1200);
        assertEquals(1200, watch.addDays(5, 3));
    }

    @Test
    void doThrowMonth() throws Exception {
        doThrow(new Exception("Some Exception")).when(Controller.getModel()).setMonth(anyInt()); // for return void
        try {
            Controller.getModel().setMonth(1);
        } catch (Exception e) {
            assertEquals("Some Exception", e.getMessage());
        }
    }

    @Test
    void doNothingMonth() throws Exception {
        doThrow(new Exception("ERROR!")).when(Controller.getModel()).setMonth(anyInt());
        doNothing().when(Controller.getModel()).setMonth(3);
        Controller.getModel().setMonth(3);
        verify(watch).setMonth(3);

    }


    @Test
    void doRealMonth() throws Exception {
        //giving permissions to real methods
       doCallRealMethod().when(Controller.getModel()).setMonth(anyInt());
       doCallRealMethod().when(Controller.getModel()).getMonth();

       Controller.getModel().setMonth(2);
       assertEquals("March", Controller.getModel().getMonth());

    }

    @Test
    void spyMinutes() throws Exception {
        watch = spy(new MyTime(2000 , 10,30,14,15));
        Controller.setModel(watch);
        assertEquals(15, Controller.getModel().getMinute());
        verify(watch, times(1)).getMinute();

    }

    @Test
    void NoMore() throws Exception {
        Controller.getModel().getMinute();
        verify(watch).getMinute(); // interaction
        verifyNoMoreInteractions(watch);

    }

    @Test
    void Only() throws Exception {
        Controller.getModel().getMinute();
        verify(watch, only()).getMinute();

    }

    @Test
    void Zero() throws Exception {
        Controller.hello(); //some processes
        verifyZeroInteractions(watch);
    }

}