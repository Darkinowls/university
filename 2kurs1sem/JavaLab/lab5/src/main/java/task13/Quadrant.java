package task13;

import java.util.Objects;

/**
 * Class for calculating data of Quadrant
 *
 * <b>side</b>, <b>perimeter</b>, <b>square</b>,
 *
 * @author Denis
 * @version 1.0
 */

public class Quadrant implements Measurable {
    /**
     * one side of Quadrant
     */
    private float side;
    /**
     * perimeter of Quadrant
     */
    private float perimeter;
    /**
     * square of Quadrant
     */
    private float square;

    /**
     * Checks bounds and returns value of Parameter .
     *
     * @param Parameter should be more than 0 to be returned
     * @return 0, if Parameter less or equal 0.
     */

    private float checkBoundsAndReturn(float Parameter) {
        if (Parameter <= 0) {
            System.out.println(Parameter + " is out of range! Set parameter > 0 !");
            return 1;
        } else return Parameter;
    }

    /**
     * Calculates perimeter and square by side of Quadrant
     */

    private void findPerimeterAndSquare() {
        perimeter = 4 * side;
        square = side * side;
    }

    /**
     *  Constructor with value side
     */

    public Quadrant(float side) {
        this.side = checkBoundsAndReturn(side);
        findPerimeterAndSquare();
    }

    /**
     *  Constructor without values
     */

    public Quadrant() {
        System.out.println("Please, set a side of Quadrant by setSide().");
    }

    /**
     * Outputs all information of object
     *
     * @return String of values
     */

    @Override
    public String toString() {
        return "Quadrant{" +
                "side=" + getSide() +
                ", perimeter=" + getPerimeter() +
                ", square=" + getSquare() +
                '}';
    }

    /**
     *
     *
     * @return Quadrant with values
     */

    public Quadrant clone() {
        return new Quadrant(this.side);
    }

    /**
     * Checks if Objects are equal.
     *
     * @param o Object
     * @return true if they are equal , false if not .
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Quadrant)) return false;
        Quadrant quadrant = (Quadrant) o;
        return Float.compare(quadrant.getSide(), getSide()) == 0 &&
                Float.compare(quadrant.getPerimeter(), getPerimeter()) == 0 &&
                Float.compare(quadrant.getSquare(), getSquare()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSide(), getPerimeter(), getSquare());
    }

    public float getSide() {
        return side;
    }

    public float getSquare() {
        return square;
    }

    public float getPerimeter() {
        return perimeter;
    }


    public void setSide(float side) {
        this.side = checkBoundsAndReturn(side);
        findPerimeterAndSquare();
    }

    public void setPerimeter(float perimeter) {
        this.perimeter = checkBoundsAndReturn(perimeter);
    }

    public void setSquare(float square) {
        this.square = checkBoundsAndReturn(square);
    }

}
