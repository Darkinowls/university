package Tasks;

import java.awt.*;

public class Colorist {
    public static Color getColor(Object MyColor) {

        return (MyColor.toString() == "Black") ? Color.BLACK :
                (MyColor.toString() == "Green") ? Color.GREEN :
                        (MyColor.toString() == "Red") ? Color.RED :
                                (MyColor.toString() == "Blue") ? Color.BLUE : Color.BLACK;
    }

}
