package Task16;

import Task16.Buildings.Castle;
import Task16.Buildings.Tower;
import Task16.Buildings.Wall;


import java.util.*;

import static java.lang.Math.*;

public class Fortress {

    public Castle castle;
    public List<Wall> walls = new ArrayList<>();
    public List<Tower> towers = new ArrayList<>();

    private int height;
    private int length;
    private int width;
    private int square;

    Fortress() {}

    public void add(IBuild o) {
        if (o instanceof Wall) {

            checkWallLocation(o.getLocation());
            walls.add((Wall) o);
            setLength(o.getLength());
            setWidth(o.getLength());
            setSquare();

        } else if (o instanceof Tower) {
            towers.add((Tower) o);
        } else if (o instanceof Castle) {
            castle = ((Castle) o);
        }
        setHeight(o.getHeight());

    }

    private void setSquare() {
        square = length * width;
    }

    private void setHeight(int height) {
        this.height = max(height, this.height);
    }

    private void setWidth(int width) {
        this.width = min(width, this.width) + max(width, this.width) / 2; // calculate width of fortress
    }

    private void setLength(int length) {
        this.length = max(length, this.length);
    }

    private void checkWallLocation(String loc) {
        for (Wall i : walls) {
            if (i.getLocation().equals(loc)) {
                System.out.println("There is already wall in " + loc + " side!");
                System.exit(-1);
            }
        }
    }


    @Override
    public String toString() {

        String str = "\nFortress{" +
                "\n\t\t" +
                "height=" + height +
                ", length=" + length +
                ", width=" + width +
                ", square=" + square;

        if(walls.size() != 0){
            str += "\n\twalls[" + walls.size() + "] = " + walls;
        }

        if(towers.size() != 0){
            str += "\n\ttowers[" + towers.size() + "] = " + towers;
        }

        if(castle != null){
            str += "\n\tcastle = " + castle;

        }

        return str + "\n} ";
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getLength() {
        return length;
    }

    public int getSquare() {
        return square;
    }
}
