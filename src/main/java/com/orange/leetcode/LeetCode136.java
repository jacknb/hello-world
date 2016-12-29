package com.orange.leetcode;

/**
 * Created by zhuningbin on 2016/9/6.
 */
public class LeetCode136 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 4};
        System.out.println(singleNumber(nums));
    }

    public static int singleNumber(int[] nums) {
        if (nums.length == 0)
            return -1;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result = result ^ nums[i];
        }
        return result;
    }
}
