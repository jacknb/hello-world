package com.orange.leetcode;

import java.util.Scanner;

/**
 * Created by znb on 16-9-19.
 * n=3输出
 * [
 * [ 1, 2, 3 ],
 * [ 8, 9, 4 ],
 * [ 7, 6, 5 ]
 * ]
 */
public class LeetCode59 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int[][] matrix = generateMatrix(n);
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    System.out.print(matrix[i][j] + "  ");
                }
                System.out.println();
            }
        }
    }

    /**
     * 输出二位
     * @param n
     * @return
     */
    public static int[][] generateMatrix(int n) {
        int[][] nums = new int[n][n];
        int k = 1;
        int left = 0, right = n - 1, top = 0, buttom = n - 1;
        while (left < right && top < buttom) {
            for (int i = left; i < right; i++) {
                //左到右
                nums[top][i] = k++;
            }
            for (int i = top; i < buttom; i++) {
                //上到下
                nums[i][right] = k++;
            }
            for (int j = right; j > left; j--) {
                //右到左
                nums[buttom][j] = k++;
            }
            for (int j = buttom; j > top; j--) {
                //下到上
                nums[j][left] = k++;
            }
            left++;
            right--;
            top++;
            buttom--;
        }
        //如果是奇数行列的话，最中心的那个点要单加
        if (n % 2 != 0)
            nums[n / 2][n / 2] = k;
        return nums;
    }
}
