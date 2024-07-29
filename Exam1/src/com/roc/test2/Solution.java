package com.roc.test2;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        String str = "10001:张三:男:1990-01-01#10002:李四:女:1989-01-09#10003:王五:男:1999-09-09#10004:刘备:男:1899-01-01#10005:孙悟空:男:1900-01-01#10006:张三:女:1999-01-01#10007:刘备:女:1999-01-01#10008:张三:女:2003-07-01#10009:猪八戒:男:1900-01-01";

        List<User> list = new ArrayList<>();
        Arrays.stream(str.split("#")).forEach(s -> list.add(new User(s)));

        Map<String, Integer> map = new HashMap<>();

        list.forEach(e -> map.merge(e.getName(), 1, (o, n) -> o + n));

        map.forEach((k, v) -> System.out.println(k + ": " + v + "次"));
    }
}
