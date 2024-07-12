package com.roc.myapi;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo2 {
    public static void main(String[] args) {
        String str = "JRE是个运行环境，JDK是个开发环境。因此写java程序的时候需要JDK，abbbbbbbb" +
                "而运行Java8程序的时候就需要JRE。而JDK里面已经包含了JRE，因此只要安装了JDK，" +
                "就可以编辑JavA21程序，也可以正常运行JaVa17程序。但由于JDK   包含了许多与运行无关的内容，占用的空间较大，" +
                "因此运行普通的JAVA14程序无须安装JDK，而只需要安装JRE即可。";

        String regex1 = "(?i)Java(?=8|14|17)";

        String regex2 = "((?i)Java)(8|14|17)";
        String regex3 = "((?i)Java)(?:8|14|17)";
        String regex31 = "(?:JavA)(8|14|21)";

        String regex4 = "((?i)Java)(?!8|14|17)";
        String regex5 = "ab+";
        String regex6 = "ab+?";
        String regex7 = "ab*?";

        Pattern p = Pattern.compile(regex1);
        Matcher m = p.matcher(str);
        while (m.find()) {
            System.out.println(m.group());
        }
    }
}
