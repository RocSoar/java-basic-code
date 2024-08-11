package com.roc.test3;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.TreeSet;

public class Solution {

    public static void main(String[] args) throws IOException {
        File file = new File("Exam2/系统菜单.txt");
        File out = new File("Exam2/系统菜单-sorted.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));
        PrintWriter pw = new PrintWriter(out);

        TreeSet<String> ts = new TreeSet<>((a, b) -> {
            int res1 = a.charAt(3) - b.charAt(3);
            int res2 = res1 == 0 ? a.split("-")[0].length() - b.split("-")[0].length() : res1;
            return res2 == 0 ? a.charAt(7) - b.charAt(7) : res2;
        });

        String line;
        while ((line = br.readLine()) != null)
            ts.add(line);
        br.close();

        ts.forEach(s -> {
            System.out.println(s.split("-")[0].length() > 4 ? "\t" + s : s);
            pw.println(s);
        });
        pw.close();

//        List<String> list = Files.readAllLines(Path.of("Exam2/系统菜单.txt")).stream().sorted((a, b) -> {
//            int res1 = a.charAt(3) - b.charAt(3);
//            int res2 = res1 == 0 ? a.split("-")[0].length() - b.split("-")[0].length() : res1;
//            return res2 == 0 ? a.charAt(7) - b.charAt(7) : res2;
//        }).toList();
//
//        list.forEach(s -> System.out.println(s.split("-")[0].length() > 4 ? "\t" + s : s));
//
//        Files.write(Path.of("Exam2/系统菜单-sorted-v2.txt"), list);
    }
}
