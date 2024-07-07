package com.roc.bytestream;

import java.io.*;
import java.util.TreeMap;

public class Practice2 {
    public static void main(String[] args) throws IOException {
        File f = new File("io/csb.txt");
//        long start, end;
//
//        start = System.currentTimeMillis();
//        baseOne(f);
//        end = System.currentTimeMillis();
//        System.out.println("baseOne" + (end - start) + "ms");
//
//        start = System.currentTimeMillis();
//        baseMulti(f);
//        end = System.currentTimeMillis();
//        System.out.println("baseMulti" + (end - start) + "ms");
//
//        start = System.currentTimeMillis();
//        bufferedOne(f);
//        end = System.currentTimeMillis();
//        System.out.println("bufferedOne" + (end - start) + "ms");
//
//        start = System.currentTimeMillis();
//        bufferedMulti(f);
//        end = System.currentTimeMillis();
//        System.out.println("bufferedMulti" + (end - start) + "ms");
        sortCSB(f);
    }

    public static File sortCSB(File src) throws IOException {
        File des = new File(src.getParent(), "sorted-" + src.getName());
        BufferedReader br = new BufferedReader(new FileReader(src));
        BufferedWriter bw = new BufferedWriter(new FileWriter(des));
        TreeMap<Integer, String> map = new TreeMap<>();
        String line;
        while ((line = br.readLine()) != null) {
            String[] ss = line.split("\\.", 2);
            map.put(Integer.parseInt(ss[0]), ss[1]);
        }
        map.forEach((k, v) -> {
            try {
                bw.write(k + "." + v);
                bw.newLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        bw.close();
        br.close();
        return des;
    }

    public static File baseOne(File file) throws IOException {
        FileInputStream fis = new FileInputStream(file);
        File des = new File(file.getParent(), "BaseOneCopied-" + file.getName());
        FileOutputStream fos = new FileOutputStream(des);

        int b;
        while ((b = fis.read()) != -1) {
            fos.write(b);
        }
        fos.close();
        fis.close();
        return des;
    }

    public static File baseMulti(File file) throws IOException {
        FileInputStream fis = new FileInputStream(file);
        File des = new File(file.getParent(), "BaseMultiCopied-" + file.getName());
        FileOutputStream fos = new FileOutputStream(des);

        byte[] buffer = new byte[1024];
        int len;
        while ((len = fis.read(buffer)) != -1) {
            fos.write(buffer, 0, len);
        }
        fos.close();
        fis.close();
        return des;
    }

    public static File bufferedOne(File file) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
        File des = new File(file.getParent(), "BufferedOneCopied-" + file.getName());
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(des));

        int b;
        while ((b = bis.read()) != -1) {
            bos.write(b);
        }
        bos.close();
        bis.close();
        return des;
    }

    public static File bufferedMulti(File file) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
        File des = new File(file.getParent(), "BufferedMultiCopied-" + file.getName());
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(des));

        int len;
        byte[] buffer = new byte[1024];
        while ((len = bis.read(buffer)) != -1) {
            bos.write(buffer, 0, len);
        }
        bos.close();
        bis.close();
        return des;
    }
}
