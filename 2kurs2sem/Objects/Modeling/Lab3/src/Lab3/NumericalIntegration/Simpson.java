package Lab3.NumericalIntegration;

public class Simpson extends Integration {

    @Override
    public double recursion(double h, double prev) {

        double sum = FUNCTION.apply(START) + FUNCTION.apply(END); // Чому

        double even = 0; // парні
        double odd = 0; // непарні

        double x = START + h;

        while (x < END) {
            odd += FUNCTION.apply(x);
            x += (h * 2);
        }

        x = START + (h * 2);

        while (x < END) {
            even += FUNCTION.apply(x);
            x += (h * 2);
        }

        odd *= 4; // добуток значень з непарними індексами
        sum += odd;

        even *= 2; // добуток значень з парними індексами
        sum += even;

        double integral = sum * h / 3;

        return integral;
        //return Runge(integral, prev, h);
    }
}
