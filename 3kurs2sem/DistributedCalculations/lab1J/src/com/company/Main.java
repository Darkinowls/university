package com.company;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static com.company.FileManager.*;
import static java.lang.Math.pow;

public class Main {

    public static void task1() {
        List<String> texts = readFiles(getPaths());
        Counter counter = new Counter();
        for (String text : texts) {
            counter.count(text);
        }
        System.out.println(counter);
    }

    public static void task2() {
        List<String> texts = readFiles(getPaths());
        Stream<Counter> countersStream = texts.stream()
                .map((String text) -> new Counter().count(text));
        Optional<Counter> totalCounter = countersStream
                .reduce(Counter::mergeCounters);
        totalCounter.ifPresent(System.out::println);
    }

    public static void task3() {
        List<String> texts = readFiles(getPaths());
        ExecutorService executor = Executors.newFixedThreadPool(4);
        Stream<Counter> countersStream = null;
        try {
            countersStream = executor.submit(() -> texts.parallelStream()
                    .map((String text) -> new Counter().count(text))).get();
            executor.shutdown();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        Optional<Counter> totalCounter = Objects.requireNonNull(countersStream).reduce(Counter::mergeCounters);
        totalCounter.ifPresent(System.out::println);
    }

    public static void trackTime(Runnable function) {
        long nowMillis = System.currentTimeMillis();
        function.run();
        System.out.println((double) (System.currentTimeMillis() - nowMillis) / 1000);
    }

    public static void main(String[] args) {

/*      I used in Counter::count
        IntStream.range(1, 10000000).forEach((i) -> pow(i, 10));
        to make more calculations */

//        trackTime(Main::task1);
//        trackTime(Main::task2);
        trackTime(Main::task3);

    }
}
