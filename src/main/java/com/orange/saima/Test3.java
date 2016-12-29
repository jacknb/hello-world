package com.orange.saima;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by znb on 16-9-17.
 * 赛码
 * 翻转数组
 */
public class Test3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            //数组长度
            int n = in.nextInt();
            //n个整数
            int[] nums = new int[n];
            int[] copy = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = in.nextInt();
                copy[i] = nums[i];
            }
            int left = 0, right = n - 1;
            Arrays.sort(copy);
            while (left < right && copy[left] == nums[left])
                left++;
            while (right >= 0 && copy[right] == nums[right])
                right--;
            int i;
            for (i = 0; i <= right - left; i++) {
                if (copy[left + i] != nums[right - i])
                    break;
            }
            if (i > right - left) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
