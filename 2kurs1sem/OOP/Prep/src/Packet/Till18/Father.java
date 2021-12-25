package Packet.Till18;

abstract class Father implements Cloneable,IFamily {
    int num;
    Father(String s){
        System.out.println(s);
    }

    public abstract void lol();

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    final void  myMethod(){
        System.out.println("MY METHOD!");
    }
}
