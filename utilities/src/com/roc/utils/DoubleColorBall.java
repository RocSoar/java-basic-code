package com.roc.utils;

import java.util.Random;

public class DoubleColorBall {
    public static void main(String[] args) {
        runLottery(1000);

//        int[] arr = generateBall2(6, 1, 33, 16);
//        Utils.printArray(arr);
//        int[] arr1 = {1, 2, 3, 4, 5, 6, 7};
//        int[] arr2 = {6, 5, 4, 3, 2, 1, 7};
//        int[] rs = compareBall(arr2, arr1, 6, 1);
//        checkNumbers(Utils.concatToNumber(rs));
//        Utils.printArray(arr1);
//        Utils.printArray(arr2);
//        Utils.printArray(rs);
    }

    public static void runLottery(int count) {
        int[] systemBall = generateBall(6, 1, 1, 33, 1, 16);
        int[] prizeArray = new int[7];
        for (int i = 0; i < count; i++) {
            int[] userBall = generateBall(6, 1, 1, 33, 1, 16);
            int[] result = compareBall(systemBall, userBall, 6, 1);
            int prize = checkNumbers(Utils.concatToNumber(result));
            prizeArray[prize]++;
            if (prize == 1) {
                Utils.printArray(systemBall);
                Utils.printArray(userBall);
                Utils.printArray(result);
                System.out.println(prize + "等奖, 花费的次数: " + i);
            }
        }
        System.out.println();
        System.out.println("奖励数组: ");
        Utils.printArray(prizeArray);
    }

    public static int[] generateBall2(int redNum, int blueNum, int redMax, int blueMax) {
        int[] ballArray = new int[redNum + blueNum];
        Random r = new Random();
        for (int i = 0; i < ballArray.length; i++) {
            if (i >= ballArray.length - blueNum)
                ballArray[i] = r.nextInt(blueMax) + 1;
            else
                ballArray[i] = r.nextInt(redMax) + 1;
        }

        return ballArray;
    }

    public static int[] generateBall(int redNum, int blueNum, int redFrom, int redTo, int blueFrom, int blueTo) {
        int[] redFull = new int[redTo - redFrom + 1];
        int[] blueFull = new int[blueTo - blueFrom + 1];
        int[] redChoiceArr = new int[redNum];
        int[] blueChoiceArr = new int[blueNum];

        for (int i = 0; i < redFull.length; i++, redFrom++) {
            redFull[i] = redFrom;
        }
        for (int i = 0; i < blueFull.length; i++, blueFrom++) {
            blueFull[i] = blueFrom;
        }

        for (int i = 0; i < redChoiceArr.length; i++) {
            int choice = Utils.randomChoiceInArray(redFull);
            redChoiceArr[i] = choice;
            redFull = Utils.remove(redFull, choice);
        }
        for (int i = 0; i < blueChoiceArr.length; i++) {
            int choice = Utils.randomChoiceInArray(blueFull);
            blueChoiceArr[i] = choice;
            blueFull = Utils.remove(blueFull, choice);
        }

        return Utils.concatArray(redChoiceArr, blueChoiceArr);
    }

    public static int[] compareBall(int[] arr1, int[] arr2, int redNum, int blueNum) {
        int[] result = new int[2];
        int[] redArr1 = Utils.copyOfRange(arr1, 0, redNum);
        int[] redArr2 = Utils.copyOfRange(arr2, 0, redNum);
        int[] blueArr1 = Utils.copyOfRange(arr1, redNum, redNum + blueNum);
        int[] blueArr2 = Utils.copyOfRange(arr2, redNum, redNum + blueNum);

        for (int i = 0; i < redArr1.length; i++) {
            if (Utils.contains(redArr2, redArr1[i]))
                result[0]++;
        }
        for (int i = 0; i < blueArr1.length; i++) {
            if (Utils.contains(blueArr2, blueArr1[i]))
                result[1]++;
        }

        return result;
    }

    public static int checkNumbers(int num) {
        return switch (num) {
            case 1, 11, 21 -> {
//                System.out.println("你获得了六等奖, 奖励5元");
                yield 6;
            }
            case 31, 40 -> {
//                System.out.println("你获得了五等奖, 奖励10元");
                yield 5;
            }
            case 41, 50 -> {
//                System.out.println("你获得了四等奖, 奖励200元");
                yield 4;
            }
            case 51 -> {
//                System.out.println("你获得了三等奖, 奖励3000元");
                yield 3;
            }
            case 60 -> {
//                System.out.println("你获得了二等奖, 奖励5000000元");
                yield 2;
            }
            case 61 -> {
                System.out.println("你获得了一等奖, 奖励10000000元");
                yield 1;
            }
            default -> {
//                System.out.println("你空手而归");
                yield 0;
            }
        };
    }
}
