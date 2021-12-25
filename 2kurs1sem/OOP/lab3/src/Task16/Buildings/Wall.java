package Task16.Buildings;


public class Wall extends Building  {

    private Boolean surroundedByPit = false;
    private Boolean entrance = false ;


    public Wall(){}

    public Wall(int height, int length, int width , String location) {
        super(height,length, width ,location);

    }

    public Wall(int height, int length, int width , String location , boolean surroundedByPit , boolean entrance) {
       super(height,length, width ,location);
       setSurroundedByPit(surroundedByPit);
       setEntrance(entrance);

    }

    public void setHeight(int height) {
        if(height < 3 || height > 25 ){
            System.out.println("Not realistic height of wall =" + height);
            System.exit(-1);
        }
        this.height = height;
    }

    public void setLength(int length) {
        if(length < 25 || length > 2000 ){
            System.out.println("Not realistic length of wall = " + length );
            System.exit(-1);
        }
        this.length = length;
    }

    public void setWidth(int width) {
        if(width < 2 || width > 10 ){
            System.out.println("Not realistic width of wall = " + width);
            System.exit(-1);
        }
        this.width = width;
    }

    public Boolean isSurroundedByPit() {
        return surroundedByPit;
    }

    public void setSurroundedByPit(Boolean surroundedByPit) {
        this.surroundedByPit = surroundedByPit;
    }

    public Boolean hasEntrance() {
        return entrance;
    }

    public void setEntrance(Boolean entrance) {
        this.entrance = entrance;
    }

    @Override
    public void setLocation(String location) {
        super.setLocation(location);
        if("center".equals(location.toLowerCase())) setEntrance(true);
    }

    @Override
    public String toString() {
        return "\n\t\tWall{" +
                super.toString() + ", " +
                "surroundedByPit=" + surroundedByPit +
                ", entrance=" + entrance +
                "} ";
    }

}
