package lab2.MethodsNonolinearSystem;

import lab2.Matrix;

import java.util.Arrays;
import java.util.function.Function;

import static java.lang.Math.abs;
import static java.lang.Math.pow;

public class NewtonMethod {

    public static double[] newtonIteration(double[] x, double error, Function<double[], Double>[][] functions) {


        double[][] y = new double[x.length][1];
        double[][] jacobi = new double[x.length][x.length];

        for (int i = 0; i < x.length; i++) {
            y[i][0] = functions[0][i].apply(x);
            for (int j = 0; j < x.length; j++) {
                jacobi[i][j] = functions[i + 1][j].apply(x);
            }
        }

        double[][] jacobiR = Matrix.ReversedMatrix(jacobi);


            double[][] diff = Matrix.MultiplyMatrix(jacobiR, y);

            double[][] colX = new double[x.length][1];
            for (int i = 0; i < x.length; i++) colX[i][0] = x[i];

            double[][] result = Matrix.SubtractMatrix(colX, diff);

            boolean end = true;


            for (int i = 0; i < result.length; i++) {
                if (abs(diff[i][0]) > error) {
                    end = false;
                    break;
                }
            }
            if (end) return Matrix.TransponateMatrix(result)[0];
            return newtonIteration(Matrix.TransponateMatrix(result)[0], error, functions);


    }

    public static double[] newtonMethod(double[] x, double error, Function<double[], Double>[][] functions) {

        if(convergence(x, functions))
            System.out.println("За достатньою умовою, метод Ньютона збігається при початкових значеннях "
                    + Arrays.toString(x));

        return newtonIteration(x, error, functions);

    }

    public static boolean convergence(double[] x, Function<double[], Double>[][] functions) {


        double[][] y = new double[x.length][1];
        double[][] jacobian = new double[x.length][x.length];

        for (int i = 0; i < x.length; i++) {
            y[i][0] = functions[0][i].apply(x);
            for (int j = 0; j < x.length; j++) {
                jacobian[i][j] = functions[i + 1][j].apply(x);
            }
        }

        double[][] jacobianR = Matrix.ReversedMatrix(jacobian);

        double L = Matrix.NormaByRow(jacobian);
        double M = Matrix.NormaByRow(jacobianR);
        double P = Matrix.NormaByRow(y);



        return (pow(M, 2) * L * P / 2 < 1);
    }


}
