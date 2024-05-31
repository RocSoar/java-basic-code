package com.roc.utils;

import java.lang.reflect.Array;
import java.util.Random;

public class Utils {
    public static <T> void printArray(T[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                System.out.print(arr[i]);
            } else {
                System.out.print(", " + arr[i]);
            }
        }
        System.out.print("]\n");
        System.out.println("length: " + arr.length);
    }

    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                System.out.print(arr[i]);
            } else {
                System.out.print(", " + arr[i]);
            }
        }
        System.out.print("]\n");
        System.out.println("length: " + arr.length);
    }

    public static void printArray(int[][] arr) {
        System.out.println("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print("[");
            for (int j = 0; j < arr[i].length; j++) {
                if (j == 0)
                    System.out.print(arr[i][j]);
                else
                    System.out.print(", " + arr[i][j]);
            }
            if (i == arr.length - 1)
                System.out.println("]");
            else
                System.out.println("],");
        }
        System.out.println("]");
    }

    public static <T> T[] copyArray(T[] arr) {
        T[] newArray = (T[]) Array.newInstance(arr.getClass().getComponentType(), arr.length);

        for (int i = 0; i < arr.length; i++) {
            newArray[i] = arr[i];
        }

        return newArray;
    }

    public static int[] copyArray(int[] arr) {
        int[] newArray = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            newArray[i] = arr[i];
        }

        return newArray;
    }

    public static <T> T[] copyOfRange(T[] arr, int from, int to) {
        if (from > to || from < 0 || from >= arr.length || to > arr.length || from == to)
            return null;

        T[] newArr = (T[]) Array.newInstance(arr.getClass().getComponentType(), to - from);
        for (int i = 0; i < newArr.length; i++, from++) {
            newArr[i] = arr[from];
        }

        return newArr;
    }

    public static int[] copyOfRange(int[] arr, int from, int to) {
        if (from > to || from < 0 || from >= arr.length || to > arr.length || from == to)
            return null;

        int[] newArr = new int[to - from];
        for (int i = 0; i < newArr.length; i++, from++) {
            newArr[i] = arr[from];
        }

        return newArr;
    }

    public static <T> boolean contains(T[] arr, T target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return true;
            }
        }
        return false;
    }


    public static boolean contains(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return true;
            }
        }
        return false;
    }

    public static int indexOf(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target)
                return i;
        }
        return -1;
    }

    public static int[] remove(int[] arr, int target) {
        int index = indexOf(arr, target);
        if (index == -1)
            return null;
        int[] newArr = new int[arr.length - 1];
        for (int i = 0, j = 0; i < newArr.length; i++, j++) {
            if (j == index)
                j++;
            newArr[i] = arr[j];
        }
        return newArr;
    }

    public static int[] removeAt(int[] arr, int index) {
        if (index < 0 || index >= arr.length)
            return null;
        int[] newArr = new int[arr.length - 1];
        for (int i = 0, j = 0; i < newArr.length; i++, j++) {
            if (j == index)
                j++;
            newArr[i] = arr[j];
        }
        return newArr;
    }

    public static int[] append(int[] arr, int target) {
        int[] newArr = new int[arr.length + 1];
        newArr[arr.length] = target;
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }

    public static int[] concatArray(int[] arr1, int[] arr2) {
        int[] newArr = new int[arr1.length + arr2.length];
        for (int i = 0; i < newArr.length; i++) {
            if (i >= arr1.length)
                newArr[i] = arr2[i - arr1.length];
            else
                newArr[i] = arr1[i];
        }
        return newArr;
    }

    public static int randomChoiceInArray(int[] arr) {
        Random r = new Random();
        return arr[r.nextInt(arr.length)];
    }

    public static <T> void reverseArrayInPlace(T[] arr) {
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            T temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public static void reverseArrayInPlace(int[] arr) {
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public static void randomArrayInPlace(int[] arr) {
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            int randomIndex = r.nextInt(arr.length);
            arr[i] = arr[randomIndex];
            arr[randomIndex] = temp;
        }
    }

    public static void randomArrayInPlace(int[] arr, int from, int to) {
        Random r = new Random();
        for (int i = from; i < to; i++) {
            int temp = arr[i];
            int randomIndex = r.nextInt(to - from) + from;
            arr[i] = arr[randomIndex];
            arr[randomIndex] = temp;
        }
    }

    public static int concatToNumber(int[] arr) {
        int num = 0;
        for (int i = 0; i < arr.length; i++) {
            num = num * 10 + arr[i];
        }
        return num;
    }

    public static int[] separateToArray(int num) {
        int temp = num;
        int len = 0;
        while (true) {
            if (num == 0)
                break;
            num /= 10;
            len++;
        }
        int[] arr = new int[len];
        for (int i = arr.length - 1; i >= 0; i--, temp /= 10) {
            arr[i] = temp % 10;
        }
        return arr;
    }

    public static int getSum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public static int getSum(int[][] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                sum += arr[i][j];
            }
        }
        return sum;
    }

    public static int[] getSumEach(int[][] arr) {
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = 0; j < arr[i].length; j++) {
                sum += arr[i][j];
            }
            result[i] = sum;
        }
        return result;
    }

    public static int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
        }
        return max;
    }

    public static int getMin(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min)
                min = arr[i];
        }
        return min;
    }

    public static char getRandomChar() {
        Random r = new Random();
        int choice = r.nextInt(2);

        return choice == 0 ?
                (char) (r.nextInt(91 - 65) + 65)
                : (char) (r.nextInt(123 - 97) + 97);

    }

    public static char getRandomChar2() {
        char[] chars = new char[52];
        for (int i = 0; i < chars.length; i++) {
            if (i < 26)
                chars[i] = (char) (65 + i);
            else
                chars[i] = (char) (97 + i - 26);
        }
        Random r = new Random();
        int randomIndex = r.nextInt(chars.length);

        return chars[randomIndex];

    }

    public static int reverseNumber(int num) {
        int reversedNum = 0;
        while (true) {
            if (num == 0)
                break;
            int ge = num % 10;
            reversedNum = reversedNum * 10 + ge;
            num /= 10;
        }

        return reversedNum;
    }

    public static int encrypt(int num, int added, int mod) {
        int[] arr = separateToArray(num);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (arr[i] + added) % mod;
        }
//        reverseArrayInPlace(arr);
        return reverseNumber(concatToNumber(arr));
    }

    public static int decrypt(int num, int added) {
        int[] arr = separateToArray(num);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0 && arr[i] < added)
                arr[i] = arr[i] + 10 - added;
            else
                arr[i] -= added;
        }
        return reverseNumber(concatToNumber(arr));
    }
}
