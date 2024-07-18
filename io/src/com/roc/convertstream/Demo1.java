package com.roc.convertstream;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Demo1 {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(new FileInputStream("io/gbkfile.txt"), "gb18030");
        char[] buffer = new char[1024];
        int len;
        while ((len = isr.read(buffer)) != -1) {
            System.out.println(new String(buffer, 0, len));
        }

//        FileWriter fw = new FileWriter("io/gbk.txt", Charset.forName("GBK"));
//        fw.write("你好");
//        fw.close();
//        FileReader fr = new FileReader("io/gbk.txt", Charset.forName("GBK"));
//        FileWriter fw = new FileWriter("io/utf-8.txt", StandardCharsets.UTF_8);
//        int c;
//        while ((c = fr.read()) != -1) {
//            fw.write(c);
//        }
//        fw.close();
//        fr.close();
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("io/gbkfile.txt"), "GBK"));
        System.out.println(br.readLine());
    }
}
