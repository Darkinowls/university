package lab2.MethodsNonlinear;

import lab2.MyFunctions;

import static java.lang.Math.abs;
import static lab2.MyFunctions.functionTask2fi;
import static lab2.SearchSegment.searchSegment;


public class IterationMethod {
    public static double first(double[] segment) {
        return (segment[0] + segment[1]) / 2;
    }

    public static double simpleIteration(double prev, double error) {

        double cross = functionTask2fi(prev);

        if (abs(cross - prev) <= error) return cross;

        return simpleIteration(cross, error);
    }

    public static double[] iterationMethod(double start, double end, double step, double error, int num) {


        double[][] segments = searchSegment(start, end, step, num, MyFunctions::functionTask2);

        double[] result = new double[segments.length];

        for (int i = 0; i < segments.length; i++) {
            result[i] = simpleIteration(first(segments[i]), error);
        }

        return result;
    }

    public static boolean convergence(double[] segment) {

        for (double v : segment) {
            double value = abs(MyFunctions.functionTask2fiDer1(v));
            if ( value >= 1 || value == 0) return false;
        }

        return true;
    }
}
