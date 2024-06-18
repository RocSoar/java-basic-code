package com.roc.myapi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo3 {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://news.sohu.com/a/749557367_121123813");
        URLConnection conn = url.openConnection();
        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        StringBuilder sb = new StringBuilder();
        while (true) {
            line = br.readLine();
            if (line == null)
                break;
            sb.append(line);
        }
        br.close();

//        爬取该网页中的所有身份证号
        String regex = "[1-9]\\d{5}(18|19|20)\\d{2}(0[1-9]|1[012])(0[1-9]|[12]\\d|3[01])\\d{3}[\\dxX]";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(sb.toString());
        List<String> list = new ArrayList<>();
        while (m.find())
            list.add(m.group());

        System.out.println(list);
    }
}
