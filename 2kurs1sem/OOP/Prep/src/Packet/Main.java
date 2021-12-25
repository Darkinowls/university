package Packet;

import Packet.Till18.IFamily;

import java.io.*;
import java.util.*;

public class Main {


    void method() {
    }

    public static void main(String[] args) {




        try (ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream("Object.txt"))) {
            StaticOutClass.StaticInnerClass outClass = new StaticOutClass.StaticInnerClass();
            ous.writeObject(outClass);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Object.txt"))) {
            StaticOutClass.StaticInnerClass outClass = (StaticOutClass.StaticInnerClass) ois.readObject();
            System.out.println(outClass.toString());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        HashSet<String> set = new HashSet<>();

        TreeMap<Integer, String> tree = new TreeMap<>();

        tree.put(1, "kik");
        tree.put(2, "Tree");
        tree.put(1, "hih");
        tree.put(-1, "mih");

        System.out.println(tree.toString());


        ArrayList<String> list = new ArrayList<>();

        list.add("myu");
        list.add("myu");
        System.out.println(Arrays.toString(list.toArray()));


    }

}
