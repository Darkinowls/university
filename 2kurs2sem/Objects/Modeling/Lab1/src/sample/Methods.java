package sample;

import java.util.Arrays;

import static sample.Matrix.*;

public class Methods {

    static float LagrangeInterpolation(float[] arrX, float[] arrY, float x) {
        float result = 0;

        for (int i = 0; i < arrX.length; i++) {
            float P = 1;

            for (int j = 0; j < i; j++) P *= (x - arrX[j]) / (arrX[i] - arrX[j]);
            for (int j = i + 1; j < arrX.length; j++) P *= (x - arrX[j]) / (arrX[i] - arrX[j]);
            //for (int j = 0; j < arrX.length; j++) if(arrX[i] - arrX[j] !=0)P *= (x - arrX[j]) / (arrX[i] - arrX[j]);

            result += P * arrY[i];
        }

        return result;
    }

    static float MyFunctionCalc(float x) {
        return (float) (Math.sin(x) + x);
    }

    static float NewtonInterpolation(float[] arrX, float[] arrY, float x) {

        float sum = arrY[0];
        for (int i = 1; i < arrX.length; i++) {

            float F = 0;
            for (int j = 0; j <= i; j++) {

                float div = 1;
                for (int k = 0; k <= i; k++)
                    if (k != j) div *= (arrX[j] - arrX[k]);

                F += arrY[j] / div;
            }

            for (int k = 0; k < i; k++)
                F *= (x - arrX[k]);
            sum += F;
        }
        return sum;

    }

    static float[] ChebishevPoints(float a, float b, int n) {

        float[] point = new float[n + 1];

        for (float i = 0; i <= n; i++)
            point[(int) i] = (float) ((a + b) / 2 + ((b - a) / 2) * Math.cos(((2 * i + 1) / (2 * n + 2)) * Math.PI));


        return point;

    }

    static float MinLagrangeInterpolation(float a, float b, int n, float x) {

        float[] arrX;
        arrX = ChebishevPoints(a, b, n);

        float[] arrY = new float[arrX.length];
        for (int i = 0; i < arrX.length; i++) arrY[i] = MyFunctionCalc(arrX[i]);

        return LagrangeInterpolation(arrX, arrY, x);
    }

    static float NewtonGregoryInterpolation(float[] arrX, float[] arrY, float x) {

        float h = Math.abs(arrX[0] - arrX[1]);

        for (int i = 0; i < arrX.length - 2; i++)
            if (h != Math.abs(arrX[i + 1] - arrX[i + 2])) {
                try {
                    throw new Exception("Can't be used! H isn't a constant");
                } catch (Exception e) {
                    e.printStackTrace();
                    return 0;
                }
            }

        float sum = 0;
        float q = (x - arrX[0]) / h;

        float[][] diff = new float[arrX.length][arrX.length];
        for (int i = 0; i < arrX.length; i++) diff[0][i] = arrY[i];


        for (int i = 1; i < arrX.length; i++)
            for (int j = 0; j < arrX.length - i; j++)
                diff[i][j] = diff[i - 1][j + 1] - diff[i - 1][j];


        for (int i = 0; i < arrY.length; i++) {

            float F = diff[i][0];

            for (int j = 0; j < i; j++) {
                F *= (q - j) / (j + 1);
            }

            sum += F;
        }

        return sum;
    }

    static float SplineInterpolation(float[] arrX, float[] arrY, float x) {

        for (int i = 0; i < arrX.length; i++) {
            if (x >= arrX[i] && x <= arrX[i + 1]) {

                float a = (arrY[i + 1] - arrY[i]) / (arrX[i + 1] - arrX[i]);
                float b = arrY[i] - a * arrX[i];

                return a * x + b;
            }
        }
        System.err.println("Spline is OUT OF BORDER!");
        return 0;
    }

    static float LeastSquares(float[][] arrX, float[][] arrY, float[] x) {


        float[][] matX = new float[arrX.length + 1][arrX[0].length];
        for (int i = 0; i < arrX.length + 1; i++)
            for (int j = 0; j < arrX[0].length; j++) {
                matX[i][j] = (i == 0) ? 1 : arrX[i - 1][j];
            }


        float[][] matY = TransponateMatrix(arrY);

        float[][] b = MultiplyMatrix(matX, TransponateMatrix(matX));

        b = ReversedMatrix(b);
        b = MultiplyMatrix(b, matX);
        b = MultiplyMatrix(b, matY);

        for (int i = 0; i < b.length; i++) System.out.println(Arrays.toString(b[i]));

        float sum = b[0][0];
        for (int i = 0; i < x.length; i++) sum += x[i] * b[i + 1][0];


        return sum;
    }

}
