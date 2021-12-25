package task31;

import java.util.Objects;

/**
 * Class for storing data of Track. Subclass of Car.
 *
 * <b>capacity</b>
 *
 * @author Denis
 * @version 1.0
 */

public class Track extends Car implements Drivable {
    /** capacity of track */
    private int capacity;

    /**
     * Constructor with capacity
     *
     * @param power
     * @param brand
     * @param cylinder
     * @param capacity
     */

    public Track(int power, String brand, int cylinder, int capacity) {
        super(power, brand, cylinder);
        this.capacity = capacity;
    }

    /**
     * Constructor without capacity
     *
     * @param power
     * @param brand
     * @param cylinder
     */

    public Track(int power, String brand, int cylinder) {
        super(power, brand, cylinder);
    }

    /**
     *
     * @return capacity of track
     */

    public int getCapacity() {
        return capacity;
    }

    /**
     * Sets a new capacity of track
     * @param capacity
     */

    public void setCapacity(int capacity) {
        if (capacity > 0) this.capacity = capacity;
        else {
            throw new IllegalArgumentException("Capacity <= 0 ! Set a new capacity.");
        }

    }

    /**
     *
     * @return clone of Track
     */

    @Override
    public Track clone() {
        return new Track(getPower(), getBrand(), getCylinder(), getCapacity());
    }

    /**
     * Compare two Tracks.
     *
     * @param o
     * @return if they are equal - true , else false.
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Track)) return false;
        Track track = (Track) o;
        return getCapacity() == track.getCapacity() &&
                getPower() == track.getPower() &&
                getCylinder() == track.getCylinder() &&
                Objects.equals(getBrand(), track.getBrand());
    }

    /**
     *
     * @return hashCode of track
     */

    @Override
    public int hashCode() {
        return Objects.hash(getCapacity(), getPower(), getBrand(), getCylinder());
    }

    /**
     *
     * @return string with all information.
     */

    @Override
    public String toString() {
        return "Track{" +
                "power=" + getPower() +
                ", brand='" + getBrand() + '\'' +
                ", cylinder=" + getCylinder() +
                ", capacity=" + capacity +
                '}';
    }
}
