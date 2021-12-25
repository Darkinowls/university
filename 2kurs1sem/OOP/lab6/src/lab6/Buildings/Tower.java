package lab6.Buildings;


import lab6.IBuild;

public class Tower extends Building  {

    private String weapon;

    public Tower(){}

    public Tower(int height, int length, int width, String location) {
        super(height, length, width, location);
    }

    public Tower(int height, int side, String location , String weapon) {
        super(height, side, side, location);
        setWeapon(weapon);
    }

    public Tower(int height, int length, int width, String location, String weapon ) {
        super(height, length, width, location);
        setWeapon(weapon);

    }

    public void setHeight(int height) {
        if (height <= 5 || height > 30) {
            System.out.println("Not realistic height of tower = " + height);
            System.exit(-1);
        }
        this.height = height;
    }

    public void setLength(int length) {
        if (length <= 5 || length > 50) {
            System.out.println("Not realistic length of tower = " + length );
            System.exit(-1);
        }
        this.length = length;
    }

    public void setWidth(int width) {
        if (width <= 5 || width > 50) {
            System.out.println("Not realistic width of tower = " + width);
            System.exit(-1);
        }
        this.width = width;
    }


    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        if(All_Weapons.contains(weapon.toLowerCase())){
            this.weapon = weapon.substring(0,1).toUpperCase();
            this.weapon += weapon.substring(1).toLowerCase();
        }else {
            IBuild.ShowAllWeapons();
            System.exit(-1);
        }

    }

    @Override
    public String toString() {
        return "\n\t\tTower{" +
                super.toString() +
                ", weapon='" + weapon +
                "'} ";
    }
}
