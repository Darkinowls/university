package lab2;


import java.util.function.UnaryOperator;

public class SearchSegment {

    public static double[][] searchSegment(double start, double end, double step,
                                           int num, UnaryOperator<Double> function) {

        if (step <= 0 || start + step > end) try {
            throw new Exception("Error in Searching segments");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        double[][] segments = new double[num][2];

        for (int i = 0; i < num; i++) {

            segments[i] = null;

            for (double j = start; j < end; j = j + step) {


                if (function.apply(j) * function.apply(j + step) < 0) {
                    segments[i] = new double[]{j, j + step};
                    break;
                }
                if (function.apply(j + step) == 0) {
                    segments[i] = new double[]{j, j + step};
                    j -= step;
                    step /= 1.1;
                }

            }
            //System.out.println(Arrays.toString(segments[i]));

            if (segments[i] == null) {
                double[][] result = new double[i][2];
                System.arraycopy(segments, 0, result, 0, i);
                return result;
            }
            start = segments[i][1];
        }



        return segments;

    }

//    public static double[] searchSegment(double start, double end, double step, UnaryOperator<Double> function) {
//
//        for (double i = start; i < end; i = i + step) {
//            if (function.apply(i) * function.apply(i + step) <= 0) {
//                return new double[]{i, i + step};
//            }
//        }
//
//        return null;
//    }


}

/**
 * if (function.apply(j) == 0) ...
 * if (function.apply(j + step) == 0) ...
 * <p>
 * Даний функціонал спрощений,
 * оскільки суть лабораторної роботи полягає у використані обчислювальних методів
 * для знаходження коренів функції з певною точністю,
 * а не у вгадуванні коренів (див. код вище).
 * <p>
 * P.S. Особисто в мене, завдання 2 не мало б жожного сенсу.
 */