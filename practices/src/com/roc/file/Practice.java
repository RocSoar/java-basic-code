package com.roc.file;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Practice {
    public static void main(String[] args) throws IOException {
        String path = "practices/aaa";
        String path2 = "practices";
        String path3 = "D:\\Learning";
        String name = "a.txt";
        String name2 = "b.avi";
        String name3 = "src";

        File d = new File(path);

        File txtF = new File(d, name);
        File aviF = new File(d, name2);
//        File toDel = new File(d, name3);

//        System.out.println(Arrays.stream(d.listFiles(Practice::isAVI)).count());

//        printFile(d, "avi");

//        File[] files = File.listRoots();
//
//        for (File file : files) {
//            printFile(file, "save");
//        }
//        recursiveDel(toDel);
        Map<String, Integer> map = countFile(d);
        map.forEach((k, v) -> System.out.println(k + ":" + v + "个"));
        System.out.println(recursiveSum(d));
    }

    //    递归查找文件扩展名
    public static void printFile(File src, String name) {
        File[] files = src.listFiles();
        if (files == null)
            return;
        for (File f : files) {
            if (f.isDirectory())
                printFile(f, name);
            else if (f.getName().endsWith(name))
                System.out.println(f);
        }
    }

    public static boolean isFile(File f, String name) {
        return f.isFile() && f.getName().endsWith(name);
    }

    //    递归删除
    public static void recursiveDel(File src) {
        File[] files = src.listFiles();
        if (files == null)
            return;
        for (File file : files) {
            if (file.isDirectory())
                recursiveDel(file);
            else file.delete();
        }
        src.delete();
    }

    //    递归统计文件类型个数
    public static Map<String, Integer> countFile(File src) {
        Map<String, Integer> map = new HashMap<>();
        recursiveCount(src, map);
        return map;
    }

    public static void recursiveCount(File src, Map<String, Integer> map) {
        File[] files = src.listFiles();
        if (files == null)
            return;
        for (File file : files) {
            if (file.isDirectory())
                recursiveCount(file, map);
            else {
                String[] ss = file.getName().split("\\.");
                String s = ss.length == 1 ? "文件" : "." + ss[ss.length - 1];
                map.merge(s, 1, (o, n) -> o + n);
            }
        }
    }

    //    递归计算文件夹大小
    public static long recursiveSum(File src) {
        long sum = 0L;
        File[] files = src.listFiles();
        if (files == null)
            return 0;
        for (File file : files) {
            if (file.isDirectory())
                sum += recursiveSum(file);
            else
                sum += file.length();
        }
        return sum;
    }
}
