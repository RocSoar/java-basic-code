package com.roc.test3;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<LocalDate, Boolean> map = new LinkedHashMap<>();

        LocalDate start = LocalDate.of(2022, 2, 3);
        LocalDate temp = start;
        System.out.println("请输入要查询的年月(yyyy-MM): ");
        LocalDate sMonth = LocalDate.parse(sc.nextLine() + "-01");
        LocalDate end = sMonth.plusMonths(1);

        for (int i = 0; start.isBefore(end); start = start.plusDays(1), i++)
            map.put(start, i % 3 == 0);

//        List<Map.Entry<LocalDate, Boolean>> list = map.entrySet().stream().toList();
//        for (int i = 0; i < list.size(); i += 3)
//            list.get(i).setValue(true);

//        Map<LocalDate, Boolean> resMap = list.stream().collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue()));
//        map.forEach((k, v) -> System.out.println(k + " " + (v ? "休息" : "上班")));
        List<Map.Entry<LocalDate, Boolean>> searchedMonth = map.entrySet().stream().skip(ChronoUnit.DAYS.between(temp, sMonth)).toList();
        searchedMonth.forEach(entry -> System.out.println(entry.getKey() + " " + (entry.getValue() ? "[休息]" : "")));
        System.out.println("----------------------");
        List<Map.Entry<LocalDate, Boolean>> restDays = searchedMonth.stream().filter(e -> e.getValue()).toList();
        restDays.forEach(e -> {
            LocalDate date = e.getKey();
            String weekDay = switch (date.getDayOfWeek()) {
                case SATURDAY -> "周六";
                case SUNDAY -> "周日";
                default -> "";
            };
            System.out.println(date + " [休息] " + weekDay);
        });
    }
}
