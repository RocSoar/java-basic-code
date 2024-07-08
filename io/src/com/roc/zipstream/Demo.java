package com.roc.zipstream;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Demo {
    public static void main(String[] args) throws IOException {
        File f = new File("practices/aaa.zip");
        unzip(f, new File("io"));
    }

    public static void unzip(File src, File des) throws IOException {
        new File(des, src.getName().split("\\.")[0]).mkdirs();
        ZipInputStream zis = new ZipInputStream(new FileInputStream(src));

        ZipEntry entry;
        while ((entry = zis.getNextEntry()) != null) {
            System.out.println(entry.getName());
            if (entry.isDirectory()) {
                new File(des, entry.getName()).mkdirs();
            } else {
                FileOutputStream fos = new FileOutputStream(new File(des, entry.getName()));
                byte[] buffer = new byte[1024];
                int len;
                while ((len = zis.read(buffer)) != -1)
                    fos.write(buffer, 0, len);

                fos.close();
                zis.closeEntry();
            }
        }
        zis.close();
    }
}
