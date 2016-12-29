package com.orange.saima;

import java.util.Scanner;

/**
 * Created by znb on 16-9-17.
 * 第一行读入一个整数x，表示要查找的数；第二行读入一个正整数n，表示待查找数组的元素个数；第三行读入n个递增整数，构成待查找的数组。
 * 整数x在数组中出现的索引位置(索引从0开始计数)；如果不存在，返回(-1)-当前数应该出现的位置。
 * 3
 * 5
 * 0 1 3 5 6
 * 输出2
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int target = in.nextInt();
            int length = in.nextInt();
            int[] nums = new int[length];
            for (int i = 0; i < length; i++) {
                nums[i] = in.nextInt();
            }
            int result = binarySearch(nums, 0, length - 1, target);
            System.out.println(result);
        }
    }

    /**
     * 二分查找
     * @param nums
     * @param low
     * @param high
     * @param target
     * @return
     */
    public static int binarySearch(int[] nums, int low, int high, int target) {
        if (nums == null || nums.length <= 0)
            return -1;
        if (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] > target) {
                return binarySearch(nums, low, mid - 1, target);
            } else if (nums[mid] < target) {
                return binarySearch(nums, mid + 1, high, target);
            } else {
                return mid;
            }
        } else {
            return -1;
        }
    }
}
