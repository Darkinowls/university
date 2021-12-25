package task25;

import java.util.Arrays;
import java.util.Objects;

/**
 * Class for storing data of Rational. Subclass of Polynomial.
 *
 * <b>divider</b>
 *
 * @author Denis
 * @version 1.0
 */

public class Rational implements Countable {

    /** Polynomial divider */
    private Polynomial divider;
    private Polynomial number;

    /**
     * Constructor for numerator and divider
     *
     * @param numerator
     * @param dividerValues
     */

    Rational(double[] numerator, double[] dividerValues) {
        this.number = new Polynomial(numerator);
        this.divider = new Polynomial(dividerValues);
        checkDividerValues();
    }

    /**
     * Constructor for numerator
     *
     * @param numerator
     */

    Rational(double[] numerator) {
        this.number = new Polynomial(numerator);
        this.divider = new Polynomial(new double[]{1});
    }


    /**
     * Clones Rational
     *
     * @return
     */

    @Override
    public Rational clone() {
        return new Rational(number.getValues(), divider.getValues());
    }

    /**
     * Checks if a divider is a zero array and sets a new value if it is.
     */

    private void checkDividerValues() {

        if (Arrays.equals(new double[4], divider.getValues())) {
            System.out.println("It can't be a zero divider! Setting a new value.");
            setDividerValues(new double[]{1});
        }
    }

    /**
     * prints Polynomial
     *
     * @param p
     */

    private void printPolynomial(Polynomial p) {

        System.out.printf("%.0f", p.getValues()[0]);

        for (int i = 1; i < p.getLength(); i++) {

            if (i == 1 && p.getValues()[i] == 1) System.out.printf(" + x");

            else if (i == 1 && p.getValues()[i] != 0) System.out.printf(" + %.0fx", p.getValues()[i]);

            else if (p.getValues()[i] != 0 && p.getValues()[i] != 1)
                System.out.printf(" + %.0fx^%d", p.getValues()[i], i);

            else if (p.getValues()[i] == 1) System.out.printf(" + x^%d", i);

        }

    }

    /**
     * Outputs rational polynomial (numerator and divider).
     */

    public void output() {

        System.out.print("( ");

        printPolynomial(number);

        System.out.print(" ) / ( ");

        printPolynomial(divider);

        System.out.println(" )");

    }

    /** sets a new divider coefficients and cheks it.
     *
      * @param values
     */

    public void setDividerValues(double[] values) {
        divider.setValues(values);
        checkDividerValues();
    }

    /**
     *
     * @return String
     */

    @Override
    public String toString() {
        return "Rational{" +
                " numerator values = " + Arrays.toString(number.getValues()) +
                ", numerator length = " + number.getLength() +
                ", divider values = " + Arrays.toString(divider.getValues()) +
                ", divider length = " + divider.getLength() +
                '}';
    }

    /**
     * Compare two rationals
     *
     * @param o
     * @return
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rational)) return false;
        Rational rational = (Rational) o;
        return number.getLength() == rational.number.getLength() &&
                divider.getLength() == rational.divider.getLength() &&
                Arrays.equals(number.getValues(), rational.number.getValues()) &&
                Arrays.equals(divider.getValues(), rational.divider.getValues());
    }

    /**
     * get hash code from rational.
     * @return
     */

    @Override
    public int hashCode() {
        return Objects.hash(divider.getLength(), divider.getValues(), number.getLength(), number.getValues() );
    }
}
