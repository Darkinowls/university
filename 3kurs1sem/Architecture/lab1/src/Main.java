
import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.Arrays;

public class Main {


    public static void main(String[] args) {

        System.out.println("\n\n\t\tЗавдання 1\n");
        MyData data = new MyData(2000, 3, 4);
        data.showAll();
        System.out.println();

        IWatch time = new MyTime(2020, 4, 7, 14, 43);
        time.showAll();
        System.out.println();

        System.out.println(time); // toString

        System.out.println("\n\n\t\tЗавдання 2");

        int num = 1;
        for (Method method : time.getClass().getMethods()) {
            if (method.isAnnotationPresent(MyAnnotation.class)) {
                try {
                    System.out.println("\n" + num++ + "th" + " method");

                    if (method.getParameterCount() == 0) {
                        System.out.print(method.getName());
                        System.out.println(" returns " + method.invoke(time));
                    } else if (method.getParameterCount() == 1) {
                        System.out.print(method.getName());
                        System.out.println(" returns " + method.invoke(time, 2) + " and sets " + 2);
                        System.out.println("New time : " + time);
                    }

                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }


        System.out.println("\n\n\t\tЗавдання 3");

        System.out.println("Name of class : " + time.getClass().getName() +
                ".\nHis modifiers in numbers : " + time.getClass().getModifiers() +
                ".\nHis modifiers : " + Modifier.toString(time.getClass().getModifiers()) + "\n");

        num = 1;
        for (Constructor constructor : time.getClass().getDeclaredConstructors()) { // беруться усі конструктори
            System.out.println(num++ + "th constructor " +
                    constructor.getName() + Arrays.toString(constructor.getParameters()));
            System.out.println(constructor); // легше та ефективніше
        }

        System.out.println("\nThe " + time.getClass().getName() + " annotations :");

        for (Annotation annotation : time.getClass().getAnnotations()) {
            System.out.println(annotation);
        }


        System.out.println("\n\n\t\tЗавдання 4");

        IWatch watch = new MyTime(2000, 4, 4, 15, 30);

        ClassLoader classLoader = watch.getClass().getClassLoader();
        Class[] classInterfaces = watch.getClass().getInterfaces();

        IWatch proxyWatch = (IWatch) Proxy.newProxyInstance(classLoader, classInterfaces, new ProxyTime(watch));

        System.out.println("Today is " + proxyWatch.getDay());

        System.out.println("Now is " + proxyWatch.getHour() + ":" + proxyWatch.getMinute());

        proxyWatch.setDay(10);

    }
}
