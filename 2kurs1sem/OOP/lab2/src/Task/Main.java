package Task;

import java.util.GregorianCalendar;

import static Task.Support.ALLPOSTS.*;

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {

        Teacher t0 = new Teacher();

        System.out.println(t0);

        Teacher t1 = new Teacher("Igor Igorenko", new GregorianCalendar(1967, 2, 20),
                1, 100, 12);

        System.out.println(t1);

        Teacher t2 = (Teacher) t1.clone();

        t2.setLoad(24);

        SHOWALLPOSTS();

        t2.setExperience(100);

        System.out.println(t2);

        if (t2.equals(t1)) System.out.println("It's the same person!");

        t2.setPost("professor");

        System.out.println(t2);

        System.out.println( t2.getFullName() + " has salary "+ t2.getSalary() + " (hrn)");

        Teacher t3 = new Teacher("Arthur Doyle", new GregorianCalendar(1990, 12, 2),
                "assistant", 14, 1, 8);

        System.out.println(t3);

        t3.setBirth(new GregorianCalendar(1991, 11, 9));

        t3.setFullName("Arthur Cannon Doyle");

        System.out.println("New data{fullName=" + t3.getFullName() + ", birth=" + t3.getBirth() + "}");

        t3.compareTeachers(t2);

        if(t3.isBirthday()) System.out.println(t3.getFullName() + " has birthday today!"); // if it is 09.11.2020

        t3.setPost(-1);
    }
}
