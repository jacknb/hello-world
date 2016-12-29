package com.orange.order;

/**
 * Created by znb on 16-9-17.
 * 插入排序
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] nums = {1, 4, 3, 7, 9, 6};
        InsertSort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    /**
     * 插入排序算法
     *
     * @param nums
     */
    public static int[] InsertSort(int[] nums) {
        int j;
        for (int i = 1; i < nums.length; i++) {
            int tmp = nums[i];
            for (j = i; j > 0 && nums[j - 1] > tmp; j--)
                //交换次序
                nums[j] = nums[j - 1];
            nums[j] = tmp;
        }
        return nums;
    }

    /**
     * 插入排序
     *
     * @param nums
     * @return
     */
    public static int[] InsertSort1(int[] nums) {
        if (nums == null || nums.length <= 0)
            return null;
        for (int i = 1; i < nums.length; i++) {
            int tmp = nums[i];
            int j = i - 1;
            while (j >= 0 && nums[j] > tmp) {
                //交换
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = tmp;
        }
        return nums;
    }

    /**
     * 折半插入排序
     *
     * @param nums
     * @return
     */
    public static int[] InsertSort2(int[] nums) {
        if (nums == null || nums.length <= 0)
            return null;
        int low, high, mid;
        for (int i = 1; i < nums.length; i++) {
            int tmp = nums[i];
            low = 0;
            high = i - 1;
            while (low <= high) {
                mid = (low + high) / 2;
                if (tmp < nums[mid])
                    high = mid - 1;
                else
                    low = mid + 1;
            }
            for (int j = i - 1; j >= high + 1; j--)
                //元素后移
                nums[j + 1] = nums[j];
            //插入
            nums[high + 1] = tmp;
        }
        return nums;
    }
}
