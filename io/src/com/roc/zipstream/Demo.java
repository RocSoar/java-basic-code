package com.roc.zipstream;

import java.io.*;
import java.util.Arrays;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class Demo {
    public static void main(String[] args) throws IOException {
//        File src = new File("io/sorted-csb.txt");
//        System.out.println(zip(src));
//        File f = new File("io/sorted-csb.zip");
//        unzip(f, new File("io"));
        File f = new File("practices/aaa");
        File f0 = new File("practices/aaa.zip");
        File f1 = new File("practices/image");
        File f10 = new File("practices/image.zip");
        File f2 = new File("io/sorted-csb.txt");
        File f3 = new File("io/sorted-csb.zip");
        File commons = new File("C:\\Users\\GPX\\Downloads\\commons-io-2.16.1-bin.zip");
//        System.out.println(zip(f));
//        unzip(zip(f), new File("io"));
        unzip(commons, new File("C:\\Users\\GPX\\Downloads"));
    }

    //    压缩指定单个文件或文件夹
    public static File zip(File src) throws IOException {
        File des;
        String name = src.getName();
        if (src.isFile()) {
            String[] ss = name.split("\\.");
            name = String.join(".", Arrays.copyOf(ss, ss.length - 1));
        }

        des = new File(src.getParent(), name + ".zip");

        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(des));
        zipRecursion(src, zos, name);
        zos.close();
        return des;
    }

    public static void zipRecursion(File src, ZipOutputStream zos, String parent) throws IOException {
        if (src.isFile()) {
            toZip(src, zos, parent);
            return;
        }

        File[] files = src.listFiles();
        if (files == null)  // 访问权限不足时的情况
            return;
        if (files.length == 0) {  // 空文件夹时的情况
            toZip(src, zos, parent);
            return;
        }

        for (File file : files) {
            if (file.isFile())
                toZip(file, zos, parent);
            else
                zipRecursion(file, zos, parent + "/" + file.getName());
        }
    }

    public static void toZip(File src, ZipOutputStream zos, String parent) throws IOException {
//        判断是文件还是空文件夹
        String name = src.isFile() ? parent + "/" + src.getName() : parent + "/";
        zos.putNextEntry(new ZipEntry(name));
        if (src.isFile()) {
            FileInputStream fis = new FileInputStream(src);
            int len;
            byte[] buffer = new byte[1024];
            while ((len = fis.read(buffer)) != -1)
                zos.write(buffer, 0, len);

            fis.close();
        }
        zos.closeEntry();
    }

    //    解压指定zip文件到指定目录
    public static void unzip(File src, File des) throws IOException {
        ZipInputStream zis = new ZipInputStream(new FileInputStream(src));
        ZipEntry entry;
        while ((entry = zis.getNextEntry()) != null) {
            System.out.println("Created ----> " + entry.getName());
            if (entry.isDirectory()) {
                new File(des, entry.getName()).mkdirs();
            } else {
                File f = new File(des, entry.getName());
                if (!f.getParentFile().exists())
                    f.getParentFile().mkdirs();

                FileOutputStream fos = new FileOutputStream(f);
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
