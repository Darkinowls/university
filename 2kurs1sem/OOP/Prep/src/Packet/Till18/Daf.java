package Packet.Till18;

public class Daf<Type> extends Father  {
    int k;
    Type i ;

    public Daf(){
        super("Father");
        System.out.println("Daughter");
    }

    @Override
    public void lol() {
        System.out.println( "Daughter!AAAAAAAAAAAA");
    }
}
