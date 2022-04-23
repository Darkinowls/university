package com.company;

import java.util.HashMap;
import java.util.Optional;
import java.util.stream.IntStream;

import static java.lang.Math.pow;


public class Counter extends HashMap<String, Integer> {

    public Counter count(String text) {

        IntStream.range(1, 10000000).forEach((i) -> pow(i, 10)); // to make more calculations

        for (String line : text.lines().toList()) {
            int value = Optional.ofNullable(super.get(line)).orElse(0);
            if (value != 0) {
                super.put(line, value + 1);
                continue;
            }
            super.put(line, 1);
        }
        return this;
    }

    public Counter mergeCounters(Counter counter) {
        counter.forEach((k, v) -> this.merge(k, v, Integer::sum));
        return this;
    }

}
