package Lab3.NumericalIntegration;

import java.util.function.UnaryOperator;

public abstract class Integration {

    static UnaryOperator<Double> FUNCTION;
    static final double ERROR = 0.001;
    static final int SEGMENTS = 10;
    public static int ITERATIONS;
    static double START;
    static double END;

    public double method(double start, double end, UnaryOperator<Double> func) throws Exception {
        if (SEGMENTS <= 0) throw new Exception("Number of segments has to be more 0");
        if (start >= end) throw new Exception("Start has be more than End");
        ITERATIONS = 0;

        FUNCTION = func;
        START = start;
        END = end;


        double h = (END - START) / SEGMENTS;

        return recursion(h, 0);
    }

    // Використовуємо принцип Рунге
    public double Runge(double integral, double prev, double h) {
        ITERATIONS++;
        if (Math.abs(integral - prev) < ERROR) return integral;
        return recursion(h / 2, integral);
    }

    public abstract double recursion(double h, double prev);

}
