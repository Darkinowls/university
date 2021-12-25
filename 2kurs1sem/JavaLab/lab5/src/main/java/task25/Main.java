package task25;

public class Main {
    public static void main(String[] args) {

        double arr[] = {1, 2, 0, 5};
        Countable p = new Rational(arr);

        System.out.println(p);

        p.output();

        p.setValues(new double[]{0, 0, 0, 1, 0, 1, 2, 0, 1});

        p.setDividerValues(new double[4]);

        System.out.println(p);

        p.output();

        Countable p2 = new Rational(new double[]{1, 2 , 0 , 1} , new double[]{0, 1 , 3 , 2 } );

        System.out.println(p2);

        p = ((Rational) p2).clone();

        if (p2.equals(p)) p.output();


    }
}
