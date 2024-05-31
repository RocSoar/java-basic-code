package com.roc.demo;

import java.util.Random;

public class HelloWorld {
    public static void main(String[] args) {
//        注释
        // 键盘录入一个三位数, 获取其中的各位 十位 百位<

        // 1.键盘录入
//        Scanner sc = new Scanner(System.in);
//        System.out.println("请输入一个三位数");
//        int number = sc.nextInt();
//
//        int ge = number % 10;
//        int shi = number / 10 % 10;
//        int bai = number / 100 % 10;
//        System.out.println(ge);
//        System.out.println(shi);
//        System.out.println(bai);
//        byte a = 20;
//        byte b = 30;
//        byte c = (byte) (a + b);
//        short s = 1;
//        int foo = 10;
//        int bar = 20;
//        int max = Math.max(foo, bar);
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter 1: ");
//        int a = sc.nextInt();
//        System.out.println("Enter 2: ");
//        int b = sc.nextInt();
//        System.out.println(a == b ? "体重相同" : a > b ? "a的体重大" : "b的体重大");
//        int a = 150;
//        int b = 180;
//        int c = 170;
//        int result = a > b ? a : b;
//        result = result > c ? result : c;
//        System.out.println(result);
//        System.out.println(-200 >>> 2);
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter number: ");
//        int number = sc.nextInt();
//        if (number % 2 == 0) {
//            System.out.println("右边");
//        } else {
//            System.out.println("左边");
//        }
        /*int num = 8;
        switch (num) {
            case 1, 2, 3, 4, 5 -> System.out.println("工作日");
            case 6, 7 -> System.out.println("休息日");
            default -> System.out.println("没有该日");

        }*/
        /*int result = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 1)
                continue;
            result += i;
        }
        System.out.println(result);*/
        /*Scanner sc = new Scanner(System.in);
        System.out.println("输入两个数:");
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        String result = "";
        if (num1 < num2) {
            for (int i = num1; i <= num2; i++) {
                if (i % 3 == 0 && i % 5 == 0) {
                    result += i + ", ";
                }
            }
        } else if (num1 > num2) {
            for (int i = num1; i >= num2; i--) {
                if (i % 3 == 0 && i % 5 == 0) {
                    result += i + ", ";
                }
            }
        } else {
            if (num1 % 3 == 0 && num1 % 5 == 0) {
                result += num1;
            }
        }
        System.out.println(result);*/

//        boolean foo = true;
//        for (; foo; ) {
////            if (i >= 10)
////            foo = false;
//            System.out.println(i);
//        }
//        float paper = 0.1f;
//        int count = 0;
//        while (paper < 8844430.0f) {
//            paper *= 2f;
//            count++;
//        }
//        System.out.println(count);
//
//        paper = 0.1f;
//        count = 0;
//        for (; paper < 8844430f; count++) {
//            paper *= 2f;
//        }
//        System.out.println(count);
//        System.out.println(9 / 10);


//        回文数
        /*Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个数");
        int num = sc.nextInt();
        int temp = num;
        int reverse = 0;
        while (true) {
            if (temp == 0)
                break;
            int ge = temp % 10;
            temp = temp / 10;
            reverse = reverse * 10 + ge;
        }
        System.out.println(reverse);
        System.out.println(num == reverse ? "是回文数" : "不是回文数");*/


//        求商求余
       /* Scanner sc = new Scanner(System.in);
        System.out.println("请输入被除数");
        int num1 = sc.nextInt();
        System.out.println("请输入除数");
        int num2 = sc.nextInt();
        int count = 0;
        while (true) {
            if (num1 < num2)
                break;
            num1 = num1 - num2;
            count++;
        }
        System.out.println("商为" + count);
        System.out.println("余数为" + num1);*/


//        逢7比过
/*        for (int i = 1; i <= 100; i++) {
            int ge = i % 10;
            int shi = i / 10;
            if (ge == 7 || shi == 7 || i % 7 == 0) {
                System.out.println("过");
            } else {
                System.out.println(i);
            }
        }*/


//        求平方根
       /* Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个正整数: ");
        long num = sc.nextLong();
        for (long i = 1; i <= num; i++) {
            if (num == 1) {
                System.out.println("平方根为1");
                break;
            }
            if (i * i > num) {
                System.out.println("平方根为" + --i);
                break;
            }
        }*/

//        求质数
       /* Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个正整数: ");
        int num = sc.nextInt();
        boolean isPrime = true;
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                isPrime = false;
                break;
            }
        }
        System.out.println(isPrime ? num + "是质数" : num + "不是质数");*/
//        求质数, 平方根范围内循环
//        Scanner sc = new Scanner(System.in);
//        System.out.println("请输入一个正整数: ");
//        int num = sc.nextInt();
//        boolean isPrime = true;
//        int count = 2;
//        int sqrt = 1;
//        while (true) {
//            if (sqrt * sqrt > num) {
//                sqrt--;
//                break;
//            }
//            sqrt++;
//        }
//        while (true) {
//            if (count * count > num)
//                break;
//            if (num % count == 0) {
//                isPrime = false;
//                break;
//            }
//            count++;
//        }
//        System.out.println(isPrime ? num + "是质数" : num + "不是质数");


//        猜数字
       /* Random rand = new Random();
        Scanner sc = new Scanner(System.in);
        int num = rand.nextInt(100) + 1;
        while (true) {
            System.out.println("请输入你猜的数字: ");
            int guessNum = sc.nextInt();
            if (guessNum == num) {
                System.out.println("你猜对了");
                break;
            } else if (guessNum < num) {
                System.out.println("小了");
            } else {
                System.out.println("大了");
            }

        }*/

        int[] arr = new int[10];
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(100) + 1;
        }

        float sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        float average = sum / arr.length;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < average)
                count++;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println("\n平均值为: " + average + "\n" + "有" + count + "个比平均值小");
    }
}
