package task31;

/**
 * Class for storing data of Car
 *
 * <b>power</b>, <b>brand</b> <b>Cylinder</b>
 *
 * @author Denis
 * @version 1.0
 */

public class Car {
    /**
     * power of car
     */
    private int power;
    /**
     * brand name of car
     */
    private String brand;
    /**
     * number of cylinders of car
     */
    private int cylinder;

    /**
     * Constructor
     *
     * @param power
     * @param brand
     * @param cylinder
     */

    public Car(int power, String brand, int cylinder) {
        setPower(power);
        setBrand(brand);
        setCylinder(cylinder);
    }

    /**
     * @return power of car
     */

    public int getPower() {
        return power;
    }

    /**
     * Sets a new power of car if it is more than 0.
     *
     * @param power
     */

    public void setPower(int power) {
        if (power > 0) this.power = power;
        else {
            throw new IllegalArgumentException("Power <= 0 ! Set a new power.");
        }
    }

    /**
     * @return name of Brand
     */

    public String getBrand() {
        return brand;
    }

    /**
     * Sets a new name of brand if it is
     *
     * @param brand
     */

    public void setBrand(String brand) {
        if (brand == "" || brand == null) this.brand = "\"Unknown brand\"";
        else this.brand = brand;
    }

    /**
     * @return number of cylinders
     */

    public int getCylinder() {
        return cylinder;
    }

    /**
     * Sets a number of cylinders if it is more than 0.
     *
     * @param cylinder
     */

    public void setCylinder(int cylinder) {

        if (cylinder > 0) this.cylinder = cylinder;
        else {
            throw new IllegalArgumentException("Cylinder <= 0 ! Set a new cylinder.");
        }
    }


}
