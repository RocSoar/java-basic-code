package com.roc.rollcall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class RollCall {

    public static void main(String[] args) {
        IntStream.range(1, 10).forEach(n -> {
            List<String> list = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e"));
            System.out.println("==================第" + n + "轮======================");
            while (!list.isEmpty()) {
                Collections.shuffle(list);
                String s = list.remove(list.size() - 1);
                System.out.println(s);
            }
        });
    }
}
