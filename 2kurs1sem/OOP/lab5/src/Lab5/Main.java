package Lab5;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;


public class Main {

    public static void main(String[] args) {

        /** 1 Завдання */

        MyDate md = new MyDate();

        System.out.println(md);

        MyTime mt = new MyTime();

        System.out.println(mt + "\n");


        /** 2 Завдання */

        Class mirror = MyTime.class;

        try {
            invoker(mirror, mt);
            invoker(mirror.getSuperclass(), mt);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(mt + "\n");

        /** 3 Завдання */

        showInfo(mirror);

        showInfo(mirror.getSuperclass());

    }

    public static void showInfo(Class mirror) {

        System.out.println(mirror + " has these constructors : ");

        for (Constructor c : mirror.getConstructors()) {
            System.out.println(c);
        }

        System.out.println(mirror + " has modifier " + Modifier.toString(mirror.getModifiers()) + "\n");
    }


    public static void invoker(Class mirror, MyTime mt) throws Exception {
        for (Method m : mirror.getDeclaredMethods()) {
            if (m.isAnnotationPresent(MyAnnotation.class)) {
                m.setAccessible(true);

                Class<?>[] types = m.getParameterTypes();
                Object[] pars = new Object[types.length];

                for (int i = 0; i < types.length; i++) {
                    if ("int".equals(types[i].getName()) || "float".equals(types[i].getName()) ) pars[i] = 10;
                    if ("String".equals(types[i].getName())) pars[i] = "Simple";
                }

                System.out.println( m + " sets " + Arrays.toString(pars) + " returns " + m.invoke(mt,pars));

            }
        }
    }
}
