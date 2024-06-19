package com.roc.myapi;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

public class DateDemo1 {
    public static void main(String[] args) throws ParseException {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒 EEEE");

//        System.out.println(sdf.format(new Date()));
//        Date date = sdf.parse("2024年6月17日 6时11分9秒 星期一");
//
//        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//
//        System.out.println(sdf2.format(date));

//        Calendar calendar = Calendar.getInstance();
//        Date date = new Date(0L);
//        calendar.setTime(date);
//        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));
//        System.out.println(ZoneId.getAvailableZoneIds().size());
//        Instant now = Instant.now();
//        System.out.println(now);
//        Instant instant = Instant.ofEpochMilli(0L);
//        System.out.println(instant);
        System.out.println(Instant.now().atZone(ZoneId.systemDefault()));
    }
}
