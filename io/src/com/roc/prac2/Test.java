package com.roc.prac2;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Test {
    public static void main(String[] args) throws IOException {
        File f = new File("io/names.txt");
        List<Student> stulist = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(f));
        String line;
        while ((line = br.readLine()) != null)
            stulist.add(new Student(line));
        br.close();
        double totalWeight = stulist.stream().map(Student::getWeight).reduce(0.0, Double::sum);
        List<Double> weightList = stulist.stream().map(s -> s.getWeight() / totalWeight).toList();

        System.out.println("total weight: " + totalWeight);
        System.out.println("weightList: " + weightList);

        AtomicInteger i = new AtomicInteger(1);
        double[] resultWeight = weightList.stream()
                .mapToDouble(w -> weightList.stream()
                        .limit(i.getAndIncrement())
                        .reduce(0.0, Double::sum)).toArray();
        double d = Math.random();

        System.out.println("resultWeight: " + Arrays.toString(resultWeight));
        System.out.println("d: " + d);

        int res = Arrays.binarySearch(resultWeight, d);
        res = res < 0 ? -res - 1 : res;
        Student stu = stulist.get(res);
        stu.setWeight(stu.getWeight() / 2.0);
        System.out.println(stu);
        PrintWriter pw = new PrintWriter(f);
        stulist.forEach(s -> pw.println(s.writeToFile()));
        pw.close();
    }
}
