package com.orange.leetcode;

/**
 * Created by zhuningbin on 2016/9/1.
 */
public class LeetCode4 {

    public static void main(String[] args) {
        int[] A = {1, 4, 6};
        int[] B = {2, 3, 5};
        System.out.println(findMedianSortedArrays(A, B));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if ((m + n) % 2 != 0) {//odd
            return (double) findKth(nums1, nums2, (m + n) / 2, 0, m - 1, 0, n - 1);
        } else {//even
            return (findKth(nums1, nums2, (m + n) / 2, 0, m - 1, 0, n - 1) + findKth(nums1, nums2, (m + n) / 2 - 1, 0, m - 1, 0, n - 1)) * 0.5;
        }
    }

    private static int findKth(int[] nums1, int[] nums2, int k, int nums1Start, int nums1End, int nums2Start, int nums2End) {
        int nums1Len = nums1End - nums1Start + 1;
        int nums2Len = nums2End - nums2Start + 1;
        if (nums1Len == 0)
            return nums2[nums2Start + k];
        if (nums2Len == 0)
            return nums1[nums1Start + k];
        if (k == 0)
            return nums1[nums1Start] < nums2[nums2Start] ? nums1[nums1Start] : nums2[nums2Start];
        int nums1Mid = nums1Len * k / (nums1Len + nums2Len);
        int nums2Mid = k - nums1Mid - 1;
        nums1Mid = nums1Mid + nums1Start;
        nums2Mid = nums2Mid + nums2Start;

        if (nums1[nums1Mid] > nums2[nums2Mid]) {
            k = k - (nums2Mid - nums2Start + 1);
            nums1End = nums1Mid;
            nums2Start = nums2Mid + 1;
        } else {
            k = k - (nums1Mid - nums1Start + 1);
            nums2End = nums2Mid;
            nums1Start = nums1Mid + 1;
        }
        return findKth(nums1, nums2, k, nums1Start, nums1End, nums2Start, nums2End);
    }
}
