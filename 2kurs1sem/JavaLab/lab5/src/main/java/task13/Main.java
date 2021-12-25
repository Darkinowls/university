package task13;

public class Main {
    public static void main(String[] args) {

        Measurable o1 = new Quadrant();

        System.out.println(o1);

        o1.setSide(-1);

        System.out.println(o1);

        o1.setSide(10);

        System.out.println(o1);

        Measurable o2 = (Quadrant) o1.clone();

        System.out.println(o2);


    }
}
