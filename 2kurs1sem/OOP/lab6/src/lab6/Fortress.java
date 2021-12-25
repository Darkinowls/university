package lab6;


import lab6.Buildings.Castle;
import lab6.Buildings.Tower;
import lab6.Buildings.Wall;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

import static java.lang.Math.*;

public class Fortress implements Serializable {

    transient private Castle castle;
    transient List<Wall> walls = new ArrayList<>();
    private List<Tower> towers = new ArrayList<>();

    private int height;
    private int length;
    private int width;
    private int square;

    Fortress() {
    }


    private void writeObject(ObjectOutputStream os) throws IOException {
        os.defaultWriteObject();

        os.writeObject(castle.getName());
        os.writeObject(castle.getYearOfConstruction());

        for (int i = 0; i < 4; i++) {
            os.writeObject(walls.get(0).hasEntrance());
        }
    }

    private void readObject(ObjectInputStream is) throws ClassNotFoundException, IOException {

        is.defaultReadObject();

        String name = is.readObject().toString();
        Castle a = new Castle(name);
        a.setYearOfConstruction((Integer) is.readObject());
        add(a);

        List<Wall> StreamWalls = new ArrayList<>();


        for (int i = 0; i < 4; i++) {
            StreamWalls.add(new Wall((Boolean) is.readObject()));
        }


        walls = StreamWalls;

    }

    void add(IBuild o) {
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

        if (walls.size() != 0) {
            str += "\n\twalls[" + walls.size() + "] = " + walls;
        }

        if (towers.size() != 0) {
            str += "\n\ttowers[" + towers.size() + "] = " + towers;
        }

        if (castle != null) {
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
