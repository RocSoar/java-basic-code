package com.roc.test3;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.TimerTask;

public class TimeTask extends TimerTask {
    LocalDateTime target;

    public TimeTask(String s) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        target = LocalDateTime.parse(s, dtf);
    }

    @Override
    public void run() {
        Duration d = Duration.between(LocalDateTime.now(), target);
        System.out.println(d.toDays() + "天 " + d.toHours() % 24 + "时 " + d.toMinutes() % 60 + "分 " + d.toSeconds() % 60 + "秒");
//        System.out.println(d.toDaysPart() + "天 " + d.toHoursPart() + "时 " + d.toMinutesPart() + "分 " + d.toSecondsPart() + "秒");
    }
}
