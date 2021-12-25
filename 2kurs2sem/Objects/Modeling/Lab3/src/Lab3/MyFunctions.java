package Lab3;

public class MyFunctions {

    public static double function1(double x) {
        return x + Math.pow(x, 3);
    }

    public static double function1der1(double x) {
        return 1 + Math.pow(x, 2) * 3;
    }
}
