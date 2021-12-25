package lab6.models;

// для патерну Chain of Responsibility
public abstract class Watch {
    public Watch next;

    public void add(Watch obj){
        Watch temp = this;
        if (temp.next == null){
            temp.next = obj;
            return;
        }

        while(temp.next != null){
            if (temp.next.next == null){
                temp.next.next = obj;
                return;
            }
            temp = temp.next;
        }
    }
}
