package Packet;

public class OutClass {

    private int x;

    OutClass() {
        x = 5;
    }

    public class InnerClass {
        int y;

        InnerClass(int y) {
            this.y = y;
        }

        void setX(int s) {
            x = s;
        }

        @Override
        public String toString() {
            return "Class{" +
                    "y=" + y +
                    ", x=" + x +
                    '}';
        }
    }


}
