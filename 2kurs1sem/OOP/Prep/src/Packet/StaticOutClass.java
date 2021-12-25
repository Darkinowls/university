package Packet;

import java.io.Serializable;

class StaticOutClass implements Serializable {
    private int x; // wont work
    static private int z;

    StaticOutClass() {
        x = 1;
        z = 5;
    }

    static class StaticInnerClass implements Serializable {
        private int y = 10;

        StaticInnerClass() {

            z = 50;
            System.out.println(y + " " + z);
        }

        @Override
        public String toString() {
            return "StaticInnerClass{" +
                    "y=" + y +
                    '}';
        }
    }
}
