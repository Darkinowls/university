package lab2;

import lab2.producers.Producer;
import lab2.producers.Terminal;
import lab2.producers.WebApp;
import lab2.workers.ThreadWorkerExecutor;
import lab2.workers.WorkItem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.Function;
import java.util.stream.IntStream;

public class Main {

    // the function that performs very important calculation!
    public static Integer function(Producer producer) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return producer.getInput().chars().max().orElse(-1);
    }

    public static void doTask(int threadNum) throws InterruptedException {
        List<Producer> producers = new ArrayList<>(8);
        producers.add(new Terminal("Hello, kitty!"));
        producers.add(new Terminal("Hello, 12345!"));
        producers.add(new WebApp("Hello, python!"));
        producers.add(new WebApp("I'm multithreading!"));
        producers.add(new Terminal("And you dont!"));
        producers.add(new Terminal("Another item"));
        producers.add(new WebApp("And another item"));
        producers.add(new Terminal("And another itemz"));

        BlockingQueue<WorkItem<Producer, Integer>> queue = new LinkedBlockingQueue<>(producers.size());
        producers.forEach(producer -> queue.add(new WorkItem<>(producer, Main::function)));
        ThreadWorkerExecutor<Producer, Integer> executor =
                new ThreadWorkerExecutor<>(threadNum, new LinkedBlockingQueue<>(queue));

        long start = System.currentTimeMillis();
        executor.start();
        executor.shutdown();
        System.out.print("Result: ");
        queue.forEach(item -> System.out.print(item.getResult() + " "));
        System.out.printf("\nTask was done with time - %dms and with thread number - %d\n\n",
                System.currentTimeMillis() - start, threadNum);
    }


    public static void main(String[] args) throws InterruptedException {
        doTask(1);
        doTask(2);
        doTask(3);
        doTask(4);
        doTask(5);
        doTask(6);
        doTask(7);
        doTask(8);
    }
}