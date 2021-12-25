package task25;

/**
 * Class for storing data of Polynomial
 *
 * <b>values</b>, <b>length</b>
 *
 * @author Denis
 * @version 1.0
 */

public class Polynomial {

    /** Array of coefficients */
    private double values[];

    /** length of Array of coefficients */
    private int length;

    /**
     * Constructor for polynomial
     *
     * @param values
     */

    public Polynomial(double[] values) {

        this.values = values;
        this.length = values.length;
    }

    /**Returns length of Array of coefficients
     *
     * @return length
     */

    public int getLength() {
        return length;
    }

    /**Returns Array of coefficients
     *
     * @return array of values
     */

    public double[] getValues() {
        return values;
    }

    /**
     * Sets new coefficients in Polynomial and sets a new length.
     *
     * @param values
     */

    public void setValues(double[] values) {
        this.length = values.length;
        this.values = values;
    }


}
