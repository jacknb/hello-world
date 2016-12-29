package com.orange.order;

/**
 * Created by Administrator on 2016/9/19.
 * 快速排序
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] nums = {50, 10, 90, 30, 70, 40, 80, 60, 20};
        quickSort(nums, 0, nums.length - 1);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    /**
     * 快速排序算法递归实现
     *
     * @param nums
     * @param low
     * @param high
     */
    public static void quickSort(int[] nums, int low, int high) {
        int pivot;
        if (low < high) {
            pivot = Partion(nums, low, high);

            //小于标志值
            quickSort(nums, low, pivot - 1);
            //大于标志值
            quickSort(nums, pivot + 1, high);
        }
    }

    /**
     * 将数值一分为二
     *
     * @param nums
     * @param low
     * @param high
     * @return
     */
    private static int Partion(int[] nums, int low, int high) {
        int pivotKey;
        pivotKey = nums[low];
        while (low < high) {
            while (low < high && pivotKey <= nums[high])
                high--;
            //将比枢轴记录小的记录交换到低端
            int tmp = nums[high];
            nums[high] = nums[low];
            nums[low] = tmp;

            while (low < high && pivotKey >= nums[low])
                low++;
            //将比枢轴记录大的记录交换到高棉
            int temp = nums[high];
            nums[high] = nums[low];
            nums[low] = temp;
        }
        return low;
    }
}
