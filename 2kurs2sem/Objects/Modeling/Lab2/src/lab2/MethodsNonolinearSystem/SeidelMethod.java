package lab2.MethodsNonolinearSystem;

import java.util.Arrays;
import java.util.function.Function;


import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class SeidelMethod {


    public static double[] approximate(double[] x, double error, Function<double[], Double>[][] functions) {

        double[] y = new double[x.length];
        double[] copyX = new double[x.length];
        System.arraycopy(x, 0, copyX, 0, x.length);


        double r = 0;
        for (int i = 0; i < x.length; i++) {
            y[i] = functions[0][i].apply(copyX);
            copyX[i] = y[i];
            r += pow(x[i] - y[i], 2);

        }
        if (sqrt(r) < error) return y;
        return approximate(y, error, functions);
    }

    public static double[] seildelMethod(double[] x, double error, Function<double[], Double>[][] functions) {

        if (convergence(x, functions))
            System.out.println("За достатньою умовою, метод Зейделля збігається при початкових значеннях "
                    + Arrays.toString(x));

        return approximate(x, error, functions);

    }

    public static boolean convergence(double[] x, Function<double[], Double>[][] functions) {
        for (int i = 1; i < functions.length; i++) {
            double sum = 0;
            for (int j = 0; j < functions[0].length; j++) {
                sum += Math.abs(functions[i][j].apply(x));
            }
            if (sum > 1) return false;

        }
        return true;
    }

}
