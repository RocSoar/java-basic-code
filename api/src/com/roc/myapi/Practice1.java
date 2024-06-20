package com.roc.myapi;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Practice1 {
    public static void main(String[] args) throws ParseException {
//        Scanner sc = new Scanner(System.in);
//
//        List<Integer> list = new ArrayList<>();
//
//        while (true) {
//            Integer sum = list.stream().reduce(0, (a, b) -> a + b);
//            if (sum > 200)
//                break;
//            String s = sc.nextLine();
//            int i = Integer.parseInt(s);
//            list.add(i);
//        }

//        parseInt();

//        toBinaryString();
        Calendar c = Calendar.getInstance();
        c.set(1992, Calendar.MARCH, 1);
        c.add(Calendar.DAY_OF_MONTH, -1);
        if (c.get(Calendar.DAY_OF_MONTH) == 29)
            System.out.println("是闰年");

        LocalDate ld = LocalDate.of(1992, 3, 1);
        LocalDate ld2 = ld.minusDays(1);
        if (ld2.getDayOfMonth() == 29)
            System.out.println("是闰年");
    }

    private static void birth() throws ParseException {
        String birth = "1992年9月17日";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        Date date = sdf.parse(birth);
        long v = (System.currentTimeMillis() - date.getTime()) / 1000 / 60 / 60 / 24;
        System.out.println(v);

        LocalDate ld1 = LocalDate.now();
        LocalDate ld2 = LocalDate.of(1992, Month.SEPTEMBER, 17);
        System.out.println(ChronoUnit.DAYS.between(ld2, ld1));
    }

    private static void toBinaryString() {
        StringBuilder sb = new StringBuilder();
        int num = 123;
        for (; num > 0; num /= 2)
            sb.insert(0, num % 2);
        System.out.println(sb);
    }

    private static void parseInt() {
        String str = "1234567891";
        String regex = "[1-9]\\d{0,9}";

        if (str.matches(regex)) {
            int reduced = str.chars().map(c -> c - 48).reduce(0, (a, b) -> a * 10 + b);
            System.out.println(reduced);
        }
    }
}
