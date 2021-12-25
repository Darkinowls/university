package lab6.Buildings;


import lab6.IBuild;

public class Castle extends Building implements IBuild {

    private String name;
    private int YearOfConstruction;

    public Castle(String name) {
        setName(name);
    }

    public Castle(int height, int length, int width, String location, String name) {
        super(height, length, width, location);
        setName(name);
    }

    public Castle(int height, int length, int width, String location, String name, int YearOfConstruction) {
        super(height, length, width, location);
        setYearOfConstruction(YearOfConstruction);
        setName(name);
    }


    public void setHeight(int height) {
        if (height < 5 || height > 75) {
            System.out.println("Not realistic height of castle = " + height);
            System.exit(-1);
        }
        this.height = height;
    }

    public void setLength(int length) {
        if (length < 20 || length > 500) {
            System.out.println("Not realistic length of castle = " + length);
            System.exit(-1);
        }
        this.length = length;
    }

    public void setWidth(int width) {
        if (width < 20 || width > 500) {
            System.out.println("Not realistic width of castle = " + width);
            System.exit(-1);
        }
        this.width = width;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearOfConstruction() {
        return YearOfConstruction;
    }

    public void setYearOfConstruction(int YearOfConstruction) {
        if (YearOfConstruction < 500 || YearOfConstruction > 1500) {
            System.out.println("It's not a medieval!");
            System.exit(-1);
        }
        this.YearOfConstruction = YearOfConstruction;
    }

    @Override
    public String toString() {
        if (getYearOfConstruction() != 0)
            return "\n\t\tCastle{" +
                    super.toString() +
                    ", name='" + name + '\'' +
                    ", YearOfConstruction=" + YearOfConstruction +
                    "} ";

        return "\n\t\tCastle{" +
                super.toString() +
                ", name='" + name + '\'' +
                "} ";
    }
}
