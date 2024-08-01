package com.roc.test5;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 7, 7, 8, 8, 9};
        int[] res = {findLeftIndex(nums, 7), findRightIndex(nums, 7)};
//        System.out.println(Arrays.toString(findIndex(nums1, 6)));
        System.out.println(Arrays.toString(res));
    }

    public static int findLeftIndex(int[] nums, int target) {
        int result = -1;
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int middle = (start + end) / 2;
            if (target < nums[middle])
                end = middle - 1;
            else if (target > nums[middle])
                start = middle + 1;
            else {
                result = middle;
                end = middle - 1;
                if (end < 0 || nums[end] != target)
                    return result;
            }
        }
        return result;
    }

    public static int findRightIndex(int[] nums, int target) {
        int result = -1;
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int middle = (start + end) / 2;
            if (target < nums[middle])
                end = middle - 1;
            else if (target > nums[middle])
                start = middle + 1;
            else {
                result = middle;
                start = middle + 1;
                if (start >= nums.length || nums[start] != target)
                    return result;
            }
        }
        return result;
    }

//    public static int[] findIndex(int[] nums, int target) {
//        int[] res = {-1, -1};
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == target) {
//                res[0] = i;
//                break;
//            }
//        }
//        for (int i = nums.length - 1; i >= 0; i--) {
//            if (nums[i] == target) {
//                res[1] = i;
//                break;
//            }
//        }
//        return res;
//    }
}
