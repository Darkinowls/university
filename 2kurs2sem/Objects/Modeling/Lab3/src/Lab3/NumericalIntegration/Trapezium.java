package Lab3.NumericalIntegration;



public class Trapezium extends Integration{


    public double recursion(double h, double prev) {

        double sum = (FUNCTION.apply(START) + FUNCTION.apply(END)) / 2;

        for (double x = START + h; x < END; x += h) {
            sum += FUNCTION.apply(x);
        }
        double integral = sum * h;

        // Використовуємо принцип Рунге
        return Runge(integral,prev ,h);
    }
}
