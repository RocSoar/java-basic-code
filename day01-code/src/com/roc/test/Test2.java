package com.roc.test;

public class Test2 {
    public static void main(String[] args) {
        /*String checkCode = "";
        for (int i = 0; i < 4; i++) {
            checkCode += getRandomChar();
        }
        Random rand = new Random();
        checkCode += rand.nextInt(10);
        System.out.println(checkCode);*/

        /*Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        Integer[] newArr = Utilities.copyArray(arr);
        newArr[0] = 88;
        Utilities.printArray(arr);
        Utilities.printArray(newArr);*/

//        int[] arr = {100, 50, 80, 80, 80, 80};
//        System.out.println("最后得分为: " + (Utilities.getSum(arr) - Utilities.getMax(arr) - Utilities.getMin(arr)) / (arr.length - 2));
//        System.out.println(Utilities.reverseNumber(5678));

//        Utilities.printArray(Utilities.separateToArray(900000));
//        System.out.println(Utilities.encrypt(1983, 5, 10));
//        System.out.println(Utilities.decrypt(8346, 5));
        /*Random random = new Random();
        int[] arr = {2, 588, 888, 1000, 10000};
        int[] hasChosen = new int[arr.length];

        for (int i = 0; i < arr.length; ) {
            int currentChoice = arr[random.nextInt(arr.length)];
            if (Utilities.contains(hasChosen, currentChoice))
                continue;
            System.out.println(currentChoice + "元的奖金已被抽出");
            hasChosen[i] = currentChoice;
            i++;
        }*/

//        int[] arr = {2, 588, 888, 1000, 10000};
//        Utilities.randomArrayInPlace(arr);
//        Utilities.printArray(arr);
    }
}
