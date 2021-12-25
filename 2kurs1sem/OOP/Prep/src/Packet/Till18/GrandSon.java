package Packet.Till18;

public class GrandSon extends Daf{
    int num;

    public GrandSon(){
        System.out.println("Grandson");
    }

    GrandSon(int num){
        this.num = num ;
        System.out.println("Grandson");
    }

    @Override
    public void lol() {
        super.lol();
        System.out.println("Grandson!AAAAAAAAAAAAAAAAA!");
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public void make (){
        super.lol();
    }


}
