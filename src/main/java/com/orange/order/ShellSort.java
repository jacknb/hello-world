package com.orange.order;

/**
 * Created by znb on 16-9-18.
 * 希尔排序算法
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] nums = {49, 38, 65, 97, 76, 13, 27, 49, 55, 04};
        shellSort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    /**
     * 希尔排序算法
     *
     * @param nums
     */
    private static void shellSort(int[] nums) {
        if (nums == null || nums.length <= 0)
            return;
        //划组排序
        for (int r = nums.length / 2; r > 0; r /= 2) {
            for (int i = r; i < nums.length; i++) {
                int tmp = nums[i];
                int j = i - r;
                while (j >= 0 && tmp < nums[j]) {
                    //交换
                    nums[j + r] = nums[j];
                    j = j - r;
                }
                //插入
                nums[j + r] = tmp;
            }
        }
    }
}
