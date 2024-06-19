package com.roc.myapi;

import java.util.Scanner;

public class IntegerDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();

        double i = Double.parseDouble(line);
        System.out.println(i);
    }
}
