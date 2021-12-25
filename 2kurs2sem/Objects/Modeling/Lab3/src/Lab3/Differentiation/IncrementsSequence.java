package Lab3.Differentiation;

import java.util.function.UnaryOperator;

public class IncrementsSequence {

    static double ERROR = 0.001;
    static double X;
    static UnaryOperator<Double> FUNCTION;
    static double H = 0.5;
    public static int ITERATIONS = 0;
    static int ACCURACY = 0;

    public static double recursion(double h, double f, double f_old) throws Exception {

        ITERATIONS++;

        double f_new;

        if (ACCURACY == 2) f_new = (FUNCTION.apply(X + h) - FUNCTION.apply(X - h)) / (2 * h);
        else if (ACCURACY == 1) f_new = (FUNCTION.apply(X + h) - FUNCTION.apply(X)) / h;
        else throw new Exception("No such accuracy!");

        if (!validation(f_new, f, f_old))
            throw new Exception("Метод послідовних приростів розходиться при значені x = " + X);

        if (Math.abs(f_new - f) < ERROR) return f_new;

        return recursion(h / 5, f_new, f);


    }

    public static double incrementsSequence(UnaryOperator<Double> func, double x, int accuracy) throws Exception {
        ITERATIONS = 0;
        FUNCTION = func;
        ACCURACY = accuracy;
        X = x;
        return recursion(H, 0, 0);
    }

    public static boolean validation(double f_new, double f, double f_old) {
        if (f == f_old && f_old == 0) return true;
        return Math.abs(f_new - f) < Math.abs(f - f_old);
    }

}
