package task31;

public class Main {
    public static void main(String[] args) {
        Drivable track = new Track(300, null, 8, 3000);

        System.out.println(track);

        track.setPower(400);

        track.setCylinder(6);

        System.out.println(track);

        Drivable t2 = new Track ( 400 , null , 6 );

        t2.setCapacity(3000);

        if (t2.equals(track)) System.out.println("They are equal!");


    }

}
