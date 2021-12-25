package Lab3.NumericalIntegration;

import java.util.function.UnaryOperator;

public class LeftRectangles extends Integration {

    public double recursion(double h, double prev) {

        double sum = 0;
        for (double x = START; x < END; x += h) {
            sum += FUNCTION.apply(x);
        }
        double integral = sum * h;

        // Використовуємо принцип Рунге
        return Runge(integral,prev ,h);
    }

}
