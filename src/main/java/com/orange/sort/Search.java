package com.orange.sort;

/**
 * Created by Administrator on 2016/10/24.
 */
public class Search {
    public static void main(String[] args) {
        int[] arr = {5, 13, 19, 21, 37, 56, 64, 75, 80, 88, 92};
        System.out.println(BinSearch(arr, 21));
        System.out.println(BinSearch(arr, 76));
        System.out.println(0x7fffffff);
    }

    /**
     * 二分查找
     *
     * @param nums
     * @param num
     * @return
     */
    public static int BinSearch(int[] nums, int num) {
        if (nums == null || nums.length <= 0)
            return 0;
        int low = 0, high = nums.length;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == num)
                return mid;
            else if (nums[mid] > num)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return 0;
    }

    public static int BiTreeSearch(int[] nums, int num) {

        return 0;
    }
}
