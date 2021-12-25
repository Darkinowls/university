package lab2.MethodsNonlinear;

import lab2.MyFunctions;

import static java.lang.Math.abs;
import static lab2.MyFunctions.functionTask1;
import static lab2.SearchSegment.searchSegment;

public class DivisionMethod {


    public static double divideSegment(double[] segment, double prev , double error) {

        double middle = (segment[0] + segment[1]) / 2;

        if (abs(functionTask1(middle) - functionTask1(prev) ) <= error) return middle;

        else if (functionTask1(segment[0]) * functionTask1(middle) < 0) segment[1] = middle;

        else if (functionTask1(segment[1]) * functionTask1(middle) < 0) segment[0] = middle;

        return divideSegment(segment , middle , error);
    }

    public static double[] divisionMethod(double start, double end, double step , double error , int num) {

        double[][] segments = searchSegment(start, end, step, num, MyFunctions::functionTask1);

        double[] result = new double[segments.length];

        for (int i = 0; i < segments.length ; i++) {
            result[i] = divideSegment(segments[i] , 0 , error);
        }

        return result;

    }

}
