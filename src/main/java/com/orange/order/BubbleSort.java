package com.orange.order;

/**
 * Created by Administrator on 2016/9/19.
 * 交换排序：冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = {49, 38, 65, 97, 76, 13, 27};
        bubbleSort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
        int[] nums1 = {49, 38, 65, 97, 76, 13, 27};
        bubbleSortMaxToMin(nums1);
        for (int num : nums1) {
            System.out.print(num + " ");
        }
    }

    /**
     * 冒泡排序算法(从小到大排序)
     *
     * @param nums
     */
    public static void bubbleSort(int[] nums) {
        int tmp;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    //交换
                    tmp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = tmp;
                }
            }
        }
    }

    /**
     * 冒泡排序（从大到小排序）
     *
     * @param nums
     */
    public static void bubbleSortMaxToMin(int[] nums) {
        int tmp;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    tmp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = tmp;
                }
            }
        }
    }
}
