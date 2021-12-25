package lab2.MethodsSLAR;

import lab2.Matrix;

public class KramerMethod {
    public static double[] kramerMethod(double[][] fullMatrix) {
        int col = fullMatrix[0].length;
        int row = fullMatrix.length;

        double[] deters = new double[row + 1];
        double[] result = new double[row];
        double[][] matrix;

        matrix = Matrix.MatrixForKramer(fullMatrix, col - 1);
        deters[0] = Matrix.DeterminateMatrix(matrix);

        //System.out.println(deters[0]);

        if (deters[0] == 0) {
            boolean InfinitySolutions = true;
            for (int i = 0; i < row ; i++) {
                matrix = Matrix.MatrixForKramer(fullMatrix, i);
                deters[i + 1] = Matrix.DeterminateMatrix(matrix);
                if(deters[i+1] != 0) {
                    InfinitySolutions = false;
                    break;
                }

            }
            System.out.println( InfinitySolutions ? "Безліч розв'язків" : "Немає розв'язків" );
            return null;

        } else for (int i = 0; i < row; i++) {

            matrix = Matrix.MatrixForKramer(fullMatrix, i);
            deters[i + 1] = Matrix.DeterminateMatrix(matrix);

            result[i] = deters[i + 1] / deters[0];

        }

        return result;

    }


}
