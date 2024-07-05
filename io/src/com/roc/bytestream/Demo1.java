package com.roc.bytestream;

import java.io.*;

public class Demo1 {
    public static void main(String[] args) throws IOException {
        String s = "io";

//        File file = new File(s, "abc.txt");
//
//        if (!file.exists())
//            file.createNewFile();
//
//        FileOutputStream fos = new FileOutputStream("io/b.txt");
//        fos.write(97);
//        fos.write(98);
//        fos.write(99);
//        fos.close();

        FileInputStream fis = new FileInputStream("io/break loop.png");
        FileOutputStream fos = new FileOutputStream("io/video.mp4");

//        byte[] bytes = new byte[1024 * 1024 * 5];
//        while (true) {
//            int len = fis.read(bytes);
//            if (len == -1)
//                break;
//            fos.write(bytes, 0, len);
//        }
//        fos.close();
//        fis.close();

        while (true) {
            int b = fis.read();
            if (b == -1)
                break;
            System.out.print((char) b + " ");
        }

        fos.close();
        fis.close();
    }
}
