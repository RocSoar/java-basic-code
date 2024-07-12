package com.roc.prac1;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test1 {
    public static void main(String[] args) throws IOException {
        String surnameURL = "https://hanyu.baidu.com/shici/detail?pid=0b2f26d4c0ddb3ee693fdb1137ee1b0d";
        String boyNameURL = "https://www.xingming.com/mingzi/nanhai/";
        String girlNameURL = "https://www.xingming.com/mingzi/nvhai/";

        String surnameStr = webCrawler(surnameURL);
        String boyNameStr = webCrawler(boyNameURL);
        String girlNameStr = webCrawler(girlNameURL);

//        System.out.println(girlNameStr);
//        getData(surnameStr, "[.\\W]{4}(?=，|。)");
        List<String> surnameTemp = getData(surnameStr, "<div class=\"text\">([\\u4E00-\\u9FA5]{1})</div>", 1);
        List<String> boyTemp = getData(boyNameStr, "<li>([\\u4E00-\\u9FA5]{1,2})</li>", 1);
        List<String> girlTemp = getData(girlNameStr, "<li>(.|..)</li>", 1);
        System.out.println(surnameTemp);
    }

    public static List<String> getData(String str, String regex, int index) {
        List<String> list = new ArrayList<>();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        while (matcher.find())
            list.add(matcher.group(index));
        return list;
    }

    public static String webCrawler(String net) throws IOException {
        StringBuilder sb = new StringBuilder();
        URL url = new URL(net);
        URLConnection conn = url.openConnection();
        InputStreamReader isr = new InputStreamReader(conn.getInputStream());
        int len;
        char[] buffer = new char[1024];
        while ((len = isr.read(buffer)) != -1)
            sb.append(buffer, 0, len);

        isr.close();
        return sb.toString();
    }
}
