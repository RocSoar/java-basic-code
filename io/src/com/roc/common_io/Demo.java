package com.roc.common_io;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class Demo {
    public static void main(String[] args) throws IOException {
//        File f1 = new File("io/csb.txt");
//        File f2 = new File("io/csb_copied.txt");
//        FileUtils.copyFile(f1, f2);

        File f1 = new File("io/image");
        File f2 = new File("io/image2");
//        FileUtils.copyDirectory(f1, f2);
        FileUtils.copyDirectoryToDirectory(f1, f2);
    }
}
