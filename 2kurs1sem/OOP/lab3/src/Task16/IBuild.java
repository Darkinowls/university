package Task16;

import java.util.Arrays;
import java.util.List;

public interface IBuild {

    void setLength(int length);
    void setWidth(int width);
    void setHeight(int height);
    void setLocation(String location);

    int getLength();
    int getWidth();
    int getHeight();
    String getLocation();

    Object clone() throws CloneNotSupportedException;


    List <String> All_Weapons = Arrays.asList( new String[]{"catapult","crossbow"});

    List<String> Sides_of_Fortress = Arrays.asList(new String[]{
            "north", "west", "east", "south", "center",
            "north-west", "north-east", "south-west", "south-east"
    });

    static void ShowAllWeapons(){

        System.out.println("\nAll weapons for towers :");
        for (String s : All_Weapons) System.out.print(s + ", ");
        System.out.printf("\b\b\n");
    }

    static void ShowSidesOfFortress(){
        System.out.println("\nPossible locations of buildings :");
        for (String s : Sides_of_Fortress )System.out.print (s + ", ");
        System.out.printf("\b\b\n");
    }
}
