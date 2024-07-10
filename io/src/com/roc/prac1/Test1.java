package com.roc.prac1;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

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
        List<String> surnameList = getData(surnameStr, "<div class=\"text\">([\\u4E00-\\u9FA5]{1})</div>", 1);
        List<String> boyList = getData(boyNameStr, "<li>([\\u4E00-\\u9FA5]{1,2})</li>", 1);
        List<String> girlList = getData(girlNameStr, "<li>(.|..)</li>", 1);

        Set<String> set = getInfo(surnameList, boyList, girlList, 5, 5);
//        System.out.println(set);

        PrintWriter pw = new PrintWriter(new FileWriter("io/names.txt"), true);
        set.forEach(s -> pw.println(s));
        pw.close();
    }

    public static Set<String> getInfo(List<String> surnames, List<String> boyNames, List<String> girlNames, int boyCount, int girlCount) {
        Random r = new Random();
        Set<String> res = new HashSet<>();
        while (res.size() < boyCount)
            res.add(surnames.get(r.nextInt(surnames.size())) + boyNames.get(r.nextInt(boyNames.size())) + "-男-" + r.nextInt(18, 40));

        while (res.size() < girlCount + boyCount)
            res.add(surnames.get(r.nextInt(surnames.size())) + girlNames.get(r.nextInt(girlNames.size())) + "-女-" + r.nextInt(18, 25));

        return res;
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
