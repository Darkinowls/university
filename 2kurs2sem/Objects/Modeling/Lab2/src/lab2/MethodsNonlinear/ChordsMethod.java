package lab2.MethodsNonlinear;

import lab2.MyFunctions;

import static java.lang.Math.abs;
import static lab2.MyFunctions.functionTask1;
import static lab2.MyFunctions.functionTask1der2;
import static lab2.SearchSegment.searchSegment;

public class ChordsMethod {


    public static double moveTo(double[] segment) {

        if (functionTask1(segment[0]) * functionTask1der2(segment[0]) > 0) return segment[0];
        else if (functionTask1(segment[1]) * functionTask1der2(segment[1]) > 0) return segment[1];

        return 0 ;
    }

    public static double first(double[] segment){
       return segment[0] - (functionTask1(segment[0]) * (segment[1] - segment[0])) /
                (functionTask1(segment[1]) - functionTask1(segment[0]));
    }

    public static double findСrossing(double prev, double moveTo, double error) {

        double cross = prev - (functionTask1(prev) * (prev - moveTo)) /
                (functionTask1(prev) - functionTask1(moveTo));

        if (abs(cross - prev) <= error) return cross;

        return findСrossing(cross, moveTo, error);
    }

    public static double[] chordsMethod(double start, double end, double step, double error, int num) {

        double[][] segments = searchSegment(start, end, step, num, MyFunctions::functionTask1);
        double[] result = new double[segments.length];


        for (int i = 0; i < segments.length; i++) {
            result[i] = findСrossing( first(segments[i]), moveTo(segments[i]), error);
        }

        return result;

    }

}
