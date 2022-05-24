package lab2.workers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.stream.BaseStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ThreadWorkerExecutor<T, R> {
    private final List<WorkerThread<T, R>> threads;

    public ThreadWorkerExecutor(int threadNum, BlockingQueue<WorkItem<T, R>> queue) {
        this.threads = new ArrayList<>(threadNum);
        IntStream.range(0, threadNum).forEach(num -> threads.add(new WorkerThread<>(queue)));
    }

    public void start() {
        threads.forEach(WorkerThread::start);
    }

    public void shutdown() throws InterruptedException {
        for (WorkerThread<T, R> thread : threads) {
            thread.join();
        }
    }

}
