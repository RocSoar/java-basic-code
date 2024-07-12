package com.roc.threadCase;

import java.util.concurrent.Callable;
import java.util.stream.IntStream;

public class MyCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        return IntStream.range(1, 101).reduce(0, Integer::sum);
    }
}
