package lab2;


public class Matrix {

    public static double[][] TransponateMatrix(double[][] arr) {

        double[][] arrT = new double[arr[0].length][arr.length];
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr[0].length; j++)
                arrT[j][i] = arr[i][j];

        return arrT;
    }

    public static double[][] MultiplyMatrix(double[][] arr1, double[][] arr2) {

        double[][] arr = new double[arr1.length][arr2[0].length];

        for (int i = 0; i < arr1.length; i++)
            for (int j = 0; j < arr2[0].length; j++) {
                arr[i][j] = 0;
                for (int k = 0; k < arr2.length; k++)
                    arr[i][j] += arr1[i][k] * arr2[k][j];

            }


        return arr;
    }

    public static double DeterminateMatrix(double[][] arr) {

        if (arr.length != arr[0].length) try {
            throw new Exception("Matrix isn't square!");
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }

        if (arr.length == 1) return arr[0][0];
        int l = arr.length - 1;
        double num = 0;

        for (int i = 0, j = 0; i < arr.length; i++) {


            double[][] temp = new double[l][l];

            for (int k = 0, n = 0; n < l * l; k++) {
                if (!(k / arr.length == i || k % arr.length == j))
                    temp[n / l][n++ % l] = arr[k / arr.length][k % arr.length];
            }

            double d = arr[i][j] * DeterminateMatrix(temp);
            if ((i + j) % 2 == 1) d *= -1;
            num += d;

        }

        return num;
    }

    public static double[][] ReversedMatrix(double[][] arr) {

        double det = DeterminateMatrix(arr);

        if (det == 0) {
            System.out.println("Визначник дорівнює нулю - матриця вироджена.");
            System.exit(-1);
        }

        double detR = 1 / det;

        double[][] arrT = TransponateMatrix(arr);

        double[][] arrR = AllyMatrix(arrT);

        return MultiplyMatrix(arrR, detR);
    }

    public static double[][] MultiplyMatrix(double[][] arr, double det) {

        double[][] returned = new double[arr.length][arr[0].length];

        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr[0].length; j++)
                returned[i][j] = det * arr[i][j];

        return returned;

    }

    public static double[][] AllyMatrix(double[][] arr) {

        double[][] arrA = new double[arr.length][arr.length];

        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr.length; j++) {

                int l = arr.length - 1; // 2
                double[][] temp = new double[l][l];

                for (int k = 0, n = 0; n < l * l; k++) {
                    if (!(k / arr.length == i || k % arr.length == j))
                        temp[n / l][n++ % l] = arr[k / arr.length][k % arr.length];
                }

                arrA[i][j] = DeterminateMatrix(temp);
                if ((i + j) % 2 == 1) arrA[i][j] *= -1;

            }
        return arrA;
    }

    public static double[][] MatrixForKramer(double[][] fullMatrix, int replace) {


        int col = fullMatrix[0].length;
        int row = fullMatrix.length;

        if (col <= replace) try {
            throw new Exception("Column is out of border!");
        } catch (Exception e) {
            e.printStackTrace();
        }

        double[][] matrix = new double[row][row];

        if (col == replace + 1) {
            for (int i = 0; i < row; i++) {
                System.arraycopy(fullMatrix[i], 0, matrix[i], 0, row);
            }
        } else {
            for (int i = 0; i < row; i++) {
                System.arraycopy(fullMatrix[i], 0, matrix[i], 0, replace);
                System.arraycopy(fullMatrix[i], col - 1, matrix[i], replace, 1);
                System.arraycopy(fullMatrix[i], replace + 1, matrix[i], replace+1, row - replace - 1 );
            }
        }

//        for (int i = 0; i < matrix.length; i++)
//            System.out.println(Arrays.toString(matrix[i]));

        return matrix;

    }

    public static double[][] SubtractMatrix(double[][] arr1, double[][] arr2){

        if (arr1.length != arr2.length || arr1[0].length != arr2[0].length) return null;

        double arr[][] = new double[arr1.length][arr1[0].length];

        for (int i = 0 ; i < arr1.length; i++){
            for (int j = 0 ; j < arr1[0].length; j++){
                arr[i][j] = arr1[i][j] - arr2[i][j];
            }
        }
        return arr;
    }

    public static double NormaByRow(double[][] arr){
        double max = arr[0][0];

        for (int i = 1; i < arr.length; i++) {
            double sum = 0;
            for (int j = 0; j < arr[0].length; j++) {
                sum += Math.abs(arr[i][j]);
            }
            if (sum > max) max = sum;
        }

        return max;
    }


}
