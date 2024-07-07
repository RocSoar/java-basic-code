package com.roc.bytestream;

import java.io.*;
import java.util.*;

public class Practice {
    public static void main(String[] args) throws IOException {
//        File f1 = new File("out");
//        copyFolder(f1, "io");

//        File f = new File("io/video.mp4");
//        File f2 = new File("io/break loop.png");
//        File f3 = new File("io/alice.txt");
//        File encryptedFile = encrypt(f3);
//        File decryptedFile = decrypt(encryptedFile);
//        System.out.println(encryptedFile.getAbsolutePath());
//        System.out.println(decryptedFile.getAbsolutePath());

        File file = new File("io/random.txt");
        writeRandomNum(file, 1200, ", ");
        File sortedFile = sortFile(file, ", ");
        System.out.println(sortedFile.getAbsolutePath());
    }

    //    递归拷贝文件夹及文件夹中的文件
    public static void copyFolder(File src, String des) throws IOException {
        File folder = new File(des, src.getName());
        folder.mkdirs();
        File[] files = src.listFiles();
        if (files == null)
            return;
        for (File file : files) {
            if (file.isDirectory())
                copyFolder(file, folder.getAbsolutePath());
            else
                copyFile(file, new File(folder, file.getName()));
        }
    }

    public static void copyFile(File src, File des) throws IOException {
        FileInputStream fis = new FileInputStream(src);
        FileOutputStream fos = new FileOutputStream(des);

        byte[] buffer = new byte[1024 * 1024 * 5];
        while (true) {
            int len = fis.read(buffer);
            if (len == -1)
                break;
            fos.write(buffer, 0, len);
        }
        fos.close();
        fis.close();
    }

    //    使用对每个字节 异或(^)2 的方式进行加密
    public static File encrypt(File src) throws IOException {
        File des = new File(src.getParent(), "encrypted-" + src.getName());
        FileInputStream fis = new FileInputStream(src);
        FileOutputStream fos = new FileOutputStream(des);
        byte[] buffer = new byte[1024 * 1024 * 5];
        while (true) {
            int len = fis.read(buffer);
            if (len == -1)
                break;
            change(buffer, 0, len);
            fos.write(buffer, 0, len);
        }
        fos.close();
        fis.close();
        return des;
    }

    public static File decrypt(File src) throws IOException {
        String name = src.getName().replace("encrypted", "decrypted");
        File des = new File(src.getParent(), name);
        FileInputStream fis = new FileInputStream(src);
        FileOutputStream fos = new FileOutputStream(des);
        byte[] buffer = new byte[1024 * 1024 * 5];
        while (true) {
            int len = fis.read(buffer);
            if (len == -1)
                break;
            change(buffer, 0, len);
            fos.write(buffer, 0, len);
        }
        fos.close();
        fis.close();
        return des;
    }

    public static void change(byte[] buffer, int off, int len) {
        for (int i = off; i < buffer.length; i++) {
            if (i - off >= len)
                break;
            buffer[i] = (byte) (buffer[i] ^ 2);
        }
    }

    //    对纯数字文本文件中的数字进行排序, 生成排好序的新文本文件
    public static File sortFile(File src, String delimiter) throws IOException {
        File des = new File(src.getParent(), "sorted-" + src.getName());
        FileReader fr = new FileReader(src);
        FileWriter fw = new FileWriter(des);
        StringBuilder sb = new StringBuilder();
        StringJoiner sj = new StringJoiner(delimiter, "", "");

        char[] buffer = new char[1024];
        while (true) {
            int len = fr.read(buffer);
            if (len == -1)
                break;
            sb.append(buffer, 0, len);
        }

        String[] ss = sb.toString().split(delimiter);
        Arrays.stream(ss).map(s -> Integer.parseInt(s)).sorted().forEach(n -> sj.add(n + ""));

        fw.write(sj.toString());
        fw.close();
        fr.close();
        return des;
    }

    //    写入指定数量的随机数到文本文件中
    public static void writeRandomNum(File file, int num, String delimiter) throws IOException {
        FileWriter fw = new FileWriter(file);
        Random r = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num; i++) {
            sb.append(r.nextInt(num));
            if (i != num - 1)
                sb.append(delimiter);
        }
        fw.write(sb.toString());
        fw.close();
    }

    //    统计英文小说中单词出现的次数
    public static void countWords(File file) throws IOException {
        BufferedReader fr = new BufferedReader(new FileReader(file));
        Map<String, Integer> map = new HashMap<>();

        String line;
        while ((line = fr.readLine()) != null) {
            Arrays.stream(line.split("\\s+")).forEach(s -> map.merge(s, 1, (o, n) -> o + n));
        }
        List<Map.Entry<String, Integer>> list = map.entrySet().stream().sorted((e1, e2) -> e2.getValue() - e1.getValue()).toList();
        list.forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));
        System.out.println(list.size());
    }
}
