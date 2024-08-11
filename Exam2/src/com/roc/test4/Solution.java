package com.roc.test4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Random r = new Random();

        List<RedPacket> redPackets = new ArrayList<>();

        IntStream.range(1, 201).forEach(i -> {
            int amount = r.nextInt(10) < 8 ? r.nextInt(1, 31) : r.nextInt(31, 101);
            redPackets.add(new RedPacket(i, amount));
        });

        Integer sum = redPackets.stream().map(o -> o.getAmount()).reduce(0, (a, b) -> a + b);

        List<FutureTask<Staff>> ftList = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            ftList.add(new FutureTask<>(new StaffCallable(i, redPackets)));
        }

        for (FutureTask<Staff> ft : ftList) {
            new Thread(ft).start();
        }

        List<Staff> staffList = new ArrayList<>();
        for (FutureTask<Staff> ft : ftList) {
            staffList.add(ft.get());
        }

        System.out.println("-------------------------------------------");
        Integer dispatchedSum = staffList.stream().map(s -> s.getAmount()).reduce(0, (a, b) -> a + b);
        staffList.stream().sorted((a, b) -> b.getAmount() - a.getAmount()).
                forEach(s -> System.out.println(s.getId() + "号员工抢红包总计: " + s.getAmount() + "元"));

        System.out.println("总红包金额: " + sum);
        System.out.println("员工抢到的总金额: " + dispatchedSum);
    }
}
