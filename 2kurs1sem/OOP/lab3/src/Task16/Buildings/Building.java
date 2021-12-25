package Task16.Buildings;

import Task16.IBuild;


public abstract class Building implements IBuild , Cloneable{

    protected int height;
    protected int length;
    protected int width;
    protected String location;

    Building(){}

    Building(int height, int length, int width , String location){
        setHeight(height);
        setLength(length);
        setWidth(width);
        setLocation(location);
    }

    public abstract void setHeight(int height);

    public abstract void setLength(int length);

    public abstract void setWidth(int width);

    public int getLength() {
        return length;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void setLocation(String location) {

        if (Sides_of_Fortress.contains(location.toLowerCase())) {
            this.location = location.substring(0, 1).toUpperCase();
            this.location += location.substring(1).toLowerCase();
        }
        else{
            IBuild.ShowSidesOfFortress();
            System.exit(-1);
        }
    }

    public String getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "location='" + location + '\''+
                ", height=" + height +
                ", length=" + length +
                ", width=" + width;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}
