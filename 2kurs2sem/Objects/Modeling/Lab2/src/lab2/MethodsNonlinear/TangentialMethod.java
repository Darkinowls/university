package lab2.MethodsNonlinear;

import lab2.MyFunctions;

import static java.lang.Math.abs;
import static lab2.MyFunctions.*;
import static lab2.SearchSegment.searchSegment;

public class TangentialMethod {

    public static double moveFrom(double[] segment) {

        if (functionTask1(segment[0]) * functionTask1der2(segment[0]) > 0) return segment[0];

        else if (functionTask1(segment[1]) * functionTask1der2(segment[1]) > 0) return segment[1];

        return 0;
    }

    public static double tangential(double prev, double error) {

        double cross = prev - functionTask1(prev) / functionTask1der1(prev);

        if (abs(cross - prev) <= error) return cross;

        return tangential(cross, error);
    }

    public static double[] tangentialMethod(double start, double end, double step, double error, int num) {

        double[][] segments = searchSegment(start, end, step, num, MyFunctions::functionTask1);

        double[] result = new double[segments.length];

        for (int i = 0; i < segments.length; i++) {
            result[i] = tangential(moveFrom(segments[i]), error);
        }

        return result;

    }


}
