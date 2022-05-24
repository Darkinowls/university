package lab2.workers;

import java.util.concurrent.Future;
import java.util.function.Function;

public class WorkItem<T, R> {
    private final T item;
    private final Function<T, R> func;
    private R result;

    public WorkItem(T item, Function<T, R> func) {
        this.item = item;
        this.func = func;
    }

    public void apply() {
        result = func.apply(item);
    }

    public R getResult(){
        return result;
    }



    public T getItem() {
        return item;
    }
}
