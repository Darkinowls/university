package task5;

import java.util.Calendar;


public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {

        Forum m = new Message();

        m.inputMessage();

        System.out.println(m);

        Forum m1 = new Message("Simple text");

        m1.setAuthor("Vasya");

        System.out.println(m1);

        Calendar cal1 = Calendar.getInstance();

        Forum m2 = new Message("Vasya", "Interface", "Another text", cal1.getTime().toString(), 1);

        System.out.println(m2);

        m1 = ((Message) m2).clone();

        m1.setAuthor("Denis");

        System.out.println(m1);

        if (!m2.equals(m1)) System.out.println("java.lang.Objects are used to compare these instances");

    }
}
