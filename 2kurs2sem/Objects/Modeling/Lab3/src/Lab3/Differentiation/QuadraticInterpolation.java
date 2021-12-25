package Lab3.Differentiation;

import java.util.function.UnaryOperator;

public class QuadraticInterpolation {

    static double H = 0;


    public static double getIntervalStart(double[] arrX, double x) throws Exception {

        for (int i = 0; i < arrX.length - 1; i++) {
            if (arrX[i] <= x && arrX[i + 1] > x) {
                H = Math.abs(arrX[i + 1] - arrX[i]);
                return arrX[i];
            }
        }
        if (arrX[arrX.length - 1] == x) {
            H = Math.abs(arrX[arrX.length - 1] - arrX[arrX.length - 2]);
            return x;
        }
        throw new Exception("x = " + x + " is not in borders!");
    }


    public static double quadraticInterpolation(double[] arrX, double[] arrY, double x) throws Exception {

        double x0 = getIntervalStart(arrX, x);

        double q = (x - x0) / H;

        // Розділені різниці
        double[][] diff = new double[arrX.length][arrX.length];
        System.arraycopy(arrY, 0, diff[0], 0, arrX.length);

        for (int i = 1; i < arrX.length; i++)
            for (int j = 0; j < arrX.length - i; j++)
                diff[i][j] = diff[i - 1][j + 1] - diff[i - 1][j];


        return (1 / H) * (diff[1][0] + (2 * q - 1) / 2 * diff[2][0]);
    }

}
