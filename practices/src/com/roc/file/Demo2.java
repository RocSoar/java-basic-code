package com.roc.file;

import java.io.File;

public class Demo2 {
    public static void main(String[] args) {
        String s = "practices/image/login/test";

        File file = new File(s);

        System.out.println(file.isFile());
    }
}
