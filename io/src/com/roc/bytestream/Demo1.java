package com.roc.bytestream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo1 {
    public static void main(String[] args) throws IOException {
        String s = "io";

        File file = new File(s, "abc.txt");

        if (!file.exists())
            file.createNewFile();

        FileOutputStream fos = new FileOutputStream("io/b.txt");
        fos.write(97);
        fos.write(98);
        fos.write(99);
        fos.close();
    }
}
