package lab2;


import static java.lang.Math.*;

public class MyFunctions {

    public static final int G = 3; //3
    public static final int K = 2; //2

    public static double functionTask1(double x) {
        return pow(x - G * K, 2) + sin(x - G * K);
    }

    public static double functionTask1der1(double x) {
        return 2 * (x - G * K) + cos(x - G * K);
    }

    public static double functionTask1der2(double x) {
        return 2 - sin(x - G * K);
    }

    public static double functionTask2(double x) {
        return (K * x - 10 * G) - sin(x - (double) (10 * G) / K);
    }

    public static double functionTask2fi(double x) {
        return (10 * G + sin(x - (double) (10 * G) / K)) / K;
    }

    public static double functionTask2fiDer1(double x) {
        return (cos(x - (double) (10 * G) / K)) / K;
    }

    public static double[][] matrixTask3() {
        return new double[][]{
                {G + 1, G + 2, G + 3, K},
                {2 * (G + 1), G + 6, G - 5, K + 1},
                {3 * (G + 1), G, -3, K + 2}};
    }

    //G(X,Y) = X || Y

    public static double functionTask4X(double[] x) {
        return (4 * G - (sin((K + 1) * x[0] + x[1] - 4 * G)) / 10) / (K + 1);
    }

    public static double functionTask4Y(double[] x) {
        return (sin((K + 1) * x[0] + x[1] - 4 * G)) / (10 * (G + 1));
    }

    public static double functionTask4XderX(double[] x) {
        return -(cos((K + 1) * x[0] + x[1] - 4 * G)) / 10;
    }

    public static double functionTask4XderY(double[] x) {
        return -cos((K + 1) * x[0] + x[1] - 4 * G) / (10 * K + 10);
    }

    public static double functionTask4YderX(double[] x) {
        return (K + 1) * cos((K + 1) * x[0] + x[1] - 4 * G) / (10 * (G + 1));
    }

    public static double functionTask4YderY(double[] x) {
        return cos((K + 1) * x[0] + x[1] - 4 * G) / (10 * (G + 1));
    }


    //F(X,Y) = 0

    public static double functionTask4F1(double[] x) {
        return (K + 1) * x[0] - 4 * G - (sin((K + 1) * x[0] + x[1] - 4 * G)) / 10;
    }

    public static double functionTask4F2(double[] x) {
        return x[1] - sin((K + 1) * x[0] + x[1] - 4 * G) / (10 * (G + 1));
    }

    public static double functionTask4F1derX(double[] x) {
        return (K + 1) + (cos((K + 1) * x[0] + x[1] - 4 * G) * (K + 1)) / 10;
    }

    public static double functionTask4F1derY(double[] x) {
        return cos((K + 1) * x[0] + x[1] - 4 * G) / 10;
    }

    public static double functionTask4F2derX(double[] x) {
        return -(cos((K + 1) * x[0] + x[1] - 4 * G) * (K + 1)) / (10 * (G + 1));
    }

    public static double functionTask4F2derY(double[] x) {
        return 1 - cos((K + 1) * x[0] + x[1] - 4 * G) / (10 * (G + 1));
    }


}
