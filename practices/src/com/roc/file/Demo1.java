package com.roc.file;

import java.io.File;
import java.text.SimpleDateFormat;

public class Demo1 {
    public static void main(String[] args) {
        String s = "practices/image/login/test.txt";

        File file = new File(s);

        long l = file.lastModified();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");

        System.out.println(sdf.format(l));
    }
}
