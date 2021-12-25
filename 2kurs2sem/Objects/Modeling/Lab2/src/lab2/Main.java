package lab2;


import lab2.MethodsNonlinear.*;
import lab2.MethodsNonolinearSystem.NewtonMethod;
import lab2.MethodsNonolinearSystem.SeidelMethod;
import lab2.MethodsSLAR.KramerMethod;

import java.util.Arrays;
import java.util.function.Function;

import static java.lang.Math.abs;
import static java.lang.Math.pow;


public class Main {


    public static void main(String[] args) {

        System.out.println("\nЗАВДАННЯ 1");


        double[] natural = DivisionMethod.divisionMethod(0, 10, 0.5, pow(0.01, 10), 3);
        double[] calculate;

        System.out.println("Корені функції : " + Arrays.toString(natural));

        ///////////////Ділення навпіл
        System.out.println("Розв'язки рівняння за методом ділення навпіл (точність 0.01) : "
                + Arrays.toString(calculate = DivisionMethod.divisionMethod(0, 10, 1, 0.01, 3)));

        System.out.println("Похибка за методом ділення навпіл : " + abs(calculate[0] - natural[0])
                + " та " + abs(calculate[1] - natural[1]));

        ////////////////Хорд
        System.out.println("\nРозв'язки рівняння за методом хорд (точність 0.01 ) : "
                + Arrays.toString(calculate = ChordsMethod.chordsMethod(0, 10, 1, 0.01, 3)));

        System.out.println("Похибка за методом хорд : " + abs(calculate[0] - natural[0])
                + " та " + abs(calculate[1] - natural[1]));

        ////////////////Дотичних(Ньютона)
        System.out.println("\nРозв'язки рівняння за методом дотичних(Ньютона) (точність 0.01 ) : "
                + Arrays.toString(calculate = TangentialMethod.tangentialMethod(0, 10, 1, 0.01, 3)));

        System.out.println("Похибка за методом дотичних(Ньютона) : " + abs(calculate[0] - natural[0])
                + " та " + abs(calculate[1] - natural[1]));

        /** ///////////////////////////////////////////////////////////////////////////////////////////////////////// */

        System.out.println("\nЗАВДАННЯ 2");

        double[] segment = new double[]{14, 16};

        System.out.println((IterationMethod.convergence(segment) ? "Метод простих ітерацій збіжний на " :
                "Метод простих ітерацій НЕ збіжний на ") + Arrays.toString(segment));

        System.out.println("Корінь функції : "
                + Arrays.toString(natural = IterationMethod.iterationMethod(0, 20, 1, pow(0.01, 10), 2)));

        System.out.println("Розв'язки рівняння за методом простих ітерацій (точність 0.01 ) : "
                + Arrays.toString(calculate = IterationMethod.iterationMethod(0, 20, 1, 0.01, 2)));

        System.out.println("Похибка за методом простих ітерацій : " + abs(calculate[0] - natural[0]));


        /** ///////////////////////////////////////////////////////////////////////////////////////////////////////// */

        System.out.println("\nЗАВДАННЯ 3");


        System.out.println("Розв'язок СЛАР методом Крамера : "
                + Arrays.toString(KramerMethod.kramerMethod(MyFunctions.matrixTask3())));


        /** ///////////////////////////////////////////////////////////////////////////////////////////////////////// */

        System.out.println("\nЗАВДАННЯ 4");

        Function<double[], Double>[][] functions = new Function[3][2];
        functions[0][0] = MyFunctions::functionTask4X;
        functions[0][1] = MyFunctions::functionTask4Y;
        functions[1][0] = MyFunctions::functionTask4XderX;
        functions[1][1] = MyFunctions::functionTask4XderY;
        functions[2][0] = MyFunctions::functionTask4YderX;
        functions[2][1] = MyFunctions::functionTask4YderY;

        System.out.println("Корені функції : "
                + Arrays.toString(natural = SeidelMethod.seildelMethod(new double[]{1, 1}, pow(0.01, 10), functions)));


        System.out.println("Розв'язок СНАР методом Зейделля : "
                + Arrays.toString(calculate = SeidelMethod.seildelMethod(new double[]{1, 1}, 0.01, functions)));

        System.out.println("Похибка за методом Зейделля : " + abs(calculate[0] - natural[0])
                + " та " + abs(calculate[1] - natural[1]));

        functions[0][0] = MyFunctions::functionTask4F1;
        functions[0][1] = MyFunctions::functionTask4F2;
        functions[1][0] = MyFunctions::functionTask4F1derX;
        functions[1][1] = MyFunctions::functionTask4F1derY;
        functions[2][0] = MyFunctions::functionTask4F2derX;
        functions[2][1] = MyFunctions::functionTask4F2derY;


        System.out.println("\nРозв'язок СНАР методом Ньютона : "
                + Arrays.toString(calculate = NewtonMethod.newtonMethod(new double[]{-2, -9}, 0.01, functions)));

        System.out.println("Похибка за методом Ньютона : " + abs(calculate[0] - natural[0])
                + " та " + abs(calculate[1] - natural[1]));
    }
}
