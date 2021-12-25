package sample;

import java.util.Arrays;

public class Matrix {

    static float[][] TransponateMatrix(float[][] arr) {

        float[][] arrT = new float[arr[0].length][arr.length];
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr[0].length; j++)
                arrT[j][i] = arr[i][j];

        return arrT;
    }

    static float[][] MultiplyMatrix(float[][] arr1, float[][] arr2) {

        float[][] arr = new float[arr1.length][arr2[0].length];

        for (int i = 0; i < arr1.length; i++)
            for (int j = 0; j < arr2[0].length; j++) {
                arr[i][j] = 0;
                for (int k = 0; k < arr2.length; k++)
                    arr[i][j] += arr1[i][k] * arr2[k][j];

            }


        return arr;
    }

    static float DeterminateMatrix(float[][] arr) {

        if (arr.length != arr[0].length) try {
            throw new Exception("Matrix isn't square!");
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }

        if (arr.length == 1) return arr[0][0];
        int l = arr.length - 1;
        float num = 0;

            for (int i = 0, j = 0; i < arr.length; i++) {


                float[][] temp = new float[l][l];

                for (int k = 0, n = 0; n < l * l; k++) {
                    if (!(k / arr.length == i || k % arr.length == j))
                        temp[n / l][n++ % l] = arr[k / arr.length][k % arr.length];
                }

                float d = arr[i][j] * DeterminateMatrix(temp);
                if ((i + j) % 2 == 1) d *= -1;
                num += d;

            }

        return num;
    }

    static float[][] ReversedMatrix(float[][] arr) {

        float det = 1 / DeterminateMatrix(arr);

        float[][] arrT = TransponateMatrix(arr);

        float[][] arrR = AllyMatrix(arrT);

        return MultiplyMatrix(arrR, det);
    }

    static float[][] MultiplyMatrix(float[][] arr, float det) {

        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr.length; j++)
                arr[i][j] *= det;

        return arr;

    }

    static float[][] AllyMatrix(float[][] arr) {

        float[][] arrA = new float[arr.length][arr.length];

        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr.length; j++) {

                int l = arr.length - 1; // 2
                float[][] temp = new float[l][l];

                for (int k = 0, n = 0; n < l * l; k++) {
                    if (!(k / arr.length == i || k % arr.length == j))
                        temp[n / l][n++ % l] = arr[k / arr.length][k % arr.length];
                }

                arrA[i][j] = DeterminateMatrix(temp);
                if ((i + j) % 2 == 1) arrA[i][j] *= -1;

            }
        return arrA;
    }


}
