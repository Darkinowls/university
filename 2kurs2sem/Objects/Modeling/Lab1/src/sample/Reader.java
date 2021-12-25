package sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Reader {

    static int LENGTH = 41;
    static int WIDTH = 4;


    static float[][] ReadX(int width, int len, String path) {
        File file =
                new File(path);
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        float[][] arrX = new float[width - 1][len];

        for (int i = 0; sc.hasNextLine(); i++) {
            if (!(i % width == (width - 1)))
                arrX[i % width][i / width] = Float.parseFloat(sc.next());
            else sc.next();

        }


        return arrX;
    }

    static float[][] ReadY(int width, int len, String path) {
        File file =
                new File(path);
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        float[][] arrY = new float[1][len];

        for (int i = 0; sc.hasNextLine(); i++) {
            if (!(i % width == (width - 1))) sc.next();
            else arrY[0][i / width] = Float.parseFloat(sc.next());

        }


        return arrY;
    }

    static float firstY(int width, String path) {
        File file =
                new File(path);
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < width-1; i++){
            sc.next();
        }

            return Float.parseFloat(sc.next());
    }

    static float[] firstX(int width, String path) {
        File file =
                new File(path);
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        float[] f = new float[width-1];

        for (int i = 0; i < width-1; i++){
            f[i] = Float.parseFloat(sc.next());
        }

        return f;
    }

}
