package com.roc.stringdemo;

import java.util.Scanner;

public class CapitalConverter {
    private final String[] capitalNum = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
    private final String[] unit = {"佰", "拾", "万", "仟", "佰", "拾", "元"};
    private final Scanner sc = new Scanner(System.in);

    public void run() {
        int num;
        while (true) {
            System.out.println("请输入金额: ");
            num = sc.nextInt();
            if (num >= 0 && num <= 9999999)
                break;
            System.out.println("请输入一个0-9999999之间的整数!");
        }
        String res = insertUnit(convertMoney(num));
        System.out.println(res);
    }

    private String convertMoney(int num) {
        String moneyStr = "";
        for (; num > 0; num /= 10) {
            int ge = num % 10;
            moneyStr = getCapitalNum(ge) + moneyStr;
        }
        int count = 7 - moneyStr.length();
        for (int i = 0; i < count; i++) {
            moneyStr = "零" + moneyStr;
        }
        return moneyStr;
    }

    private String insertUnit(String str) {
        String result = "";
        for (int i = 0; i < unit.length; i++) {
            result = result + str.charAt(i) + unit[i];
        }
        return result;
    }

    private String getCapitalNum(int num) {
        if (num < 0 || num >= capitalNum.length)
            return "";
        return capitalNum[num];
    }
}
