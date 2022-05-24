package lab2.workers;

import java.util.concurrent.BlockingQueue;
import java.util.stream.IntStream;

public class WorkerThread<T, R> extends Thread {
    private final BlockingQueue<WorkItem<T, R>> queue;

    public WorkerThread(BlockingQueue<WorkItem<T, R>> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true){
            WorkItem<T, R> workItem = queue.poll();
            if (workItem == null) return;
            workItem.apply();
        }
    }
}
