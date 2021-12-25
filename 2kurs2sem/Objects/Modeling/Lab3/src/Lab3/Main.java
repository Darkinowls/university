package Lab3;

import Lab3.Differentiation.IncrementsSequence;
import Lab3.Differentiation.QuadraticInterpolation;
import Lab3.NumericalIntegration.LeftRectangles;
import Lab3.NumericalIntegration.Simpson;
import Lab3.NumericalIntegration.Trapezium;

import java.util.Arrays;

public class Main {

    static int G = 3;
    static int K = 2;

    public static void Task1() throws Exception {

        System.out.println("\n\nДИФЕРЕНЦІЮВАННЯ");

        System.out.println("\nМЕТОД ПОСЛІДОВНИХ ПРИРОСТІВ");

        double x = G - 2 * K - 2;

        System.out.println("При x = " + x);

        double acc1 = IncrementsSequence.incrementsSequence(MyFunctions::function1, x, 1);
        double num1 = IncrementsSequence.ITERATIONS;

        double acc2 = IncrementsSequence.incrementsSequence(MyFunctions::function1, x, 2);
        double num2 = IncrementsSequence.ITERATIONS;

        double real = MyFunctions.function1der1(x);

        System.out.println("Кількість ітерацій методів послідовних приростів:" +
                "\nТочність 1 : " + num1 +
                "\nТочність 2 : " + num2);

        System.out.println("Значення здобуті методоми послідовних приростів:" +
                "\nТочність 1 : " + acc1 +
                "\nТочність 2 : " + acc2 +
                "\nТочне значення : " + real);

        System.out.println("Абсолютна похибка для 1-ої точності : " + Math.abs(acc1 - real) +
                "\nАбсолютна похибка для 2-ої точності : " + Math.abs(acc2 - real));
    }

    public static void Task2() throws Exception {

        System.out.println("\nМЕТОД КВАДРАТИЧНОЇ ІНТЕРПОЛЯЦІЇ");

        double x = G - 2 * K - 2;

        System.out.println("При x = " + x);

        double[] arrX = new double[]{G - 2 * K - 3, G - 2 * K - 1.5, G - 2 * K};

        double[] arrY = new double[arrX.length];

        for (int i = 0; i < arrX.length; i++) {
            arrY[i] = MyFunctions.function1(arrX[i]);
        }

        System.out.println("Таблиця з даними");
        System.out.println("X : " + Arrays.toString(arrX));
        System.out.println("Y : " + Arrays.toString(arrY));

        double quadric = QuadraticInterpolation.quadraticInterpolation(arrX, arrY, x);

        double real = MyFunctions.function1der1(x);

        System.out.println("Значення здобуте методом квадратичної інтерполяції : " + quadric);

        System.out.println("Значення похідної функції в точці : " + real);

        System.out.println("Абсолютна похибка для методу квадратичної інтерполяції : " + Math.abs(quadric - real));
    }

    public static void Task3() throws Exception {


        System.out.println("\n\nІНТЕГРУВАННЯ");

        final double real = -71.25; // Значення взято з калькулятора інтегралів

        ///////////////
        System.out.println("\nМЕТОД ЛІВИХ ПРЯМОКУТНИКІВ");

        double left = (new LeftRectangles()).method(G - 2 * K - 3, G - 2 * K, MyFunctions::function1);

        System.out.println("Значення здобуте методом лівих прямокутників : " + left);

        System.out.println("Кількість ітерацій для знаходження цього значення : " + LeftRectangles.ITERATIONS);

        System.out.println("Точне значення : " + real);

        System.out.println("Абсолютна похибка для методу лівих прямокутників : " + Math.abs(left - real));

        ////////////////
        System.out.println("\nМЕТОД ТРАПЕЦІЙ");

        double trap = (new Trapezium()).method(G - 2 * K - 3, G - 2 * K, MyFunctions::function1);

        System.out.println("Значення здобуте методом трапецій : " + trap);

        System.out.println("Кількість ітерацій для знаходження цього значення : " + Trapezium.ITERATIONS);

        System.out.println("Точне значення : " + real);

        System.out.println("Абсолютна похибка для методу трапецій : " + Math.abs(trap - real));

        ////////////////
        System.out.println("\nМЕТОД СІМПСОНА");

        double simp = (new Simpson()).method(G - 2 * K - 3, G - 2 * K, MyFunctions::function1);

        System.out.println("Значення здобуте методом Сімпсона : " + simp);

        System.out.println("Кількість ітерацій для знаходження цього значення : " + Simpson.ITERATIONS);

        System.out.println("Точне значення : " + real);

        System.out.println("Абсолютна похибка для методу Сімпсона : " + Math.abs(simp - real));

    }

    public static void main(String[] args) throws Exception {

        Task1();
        Task2();
        Task3();


    }
}
