package lab6;

import lab6.Buildings.Castle;
import lab6.Buildings.Tower;
import lab6.Buildings.Wall;

import java.io.*;



public class Main  {

    public static void main(String[] args) throws Exception {

        IBuild w1 = new Wall(20 ,100 ,10 , "South" , true ,false);

        IBuild w2 = (IBuild) w1.clone();

        //System.out.println(w2);

        ((Wall) w2).setEntrance(true);

        //ShowAllWeapons();

        //ShowSidesOfFortress();

        w2.setLocation("south-east");

        IBuild w3 = new Wall(18 , 200 , 10 , "North" , true , true);

        IBuild tower = new Tower(22 , 30 , "North" , "catapult" );

        IBuild castle = new Castle(30 ,40 ,40, "North" , "Kelt pride" , 1300);

        Fortress fortress = new Fortress ();

        fortress.add(w1);

        fortress.add(w2);

        fortress.add(w3);

        fortress.add( new Wall(5 , 50 , 7 , "West" ) );

        fortress.add(tower);

        fortress.add(castle);

        fortress.add(new Tower(24 , 40, 50, "South-east" , "crossbow"));

        System.out.println(fortress);

        /** Завдання зі серіалізацією */

        System.out.println("\n\n\t\t\tAfter Serialization:\n\n");

        FileOutputStream stream = new FileOutputStream("mybin.txt");
        ObjectOutputStream ObjO = new ObjectOutputStream(stream);
        ObjO.writeObject(fortress);
        stream.flush();
        stream.close();

        ObjectInputStream ObjI = new ObjectInputStream(new FileInputStream("mybin.txt"));
        Fortress f = (Fortress) ObjI.readObject();
        System.out.println(f);


    }

}
