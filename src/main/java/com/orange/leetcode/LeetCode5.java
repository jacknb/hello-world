package com.orange.leetcode;

/**
 * Created by zhuningbin on 2016/9/5.
 */
public class LeetCode5 {
    public static void main(String[] args) {
        String s = "abcba";
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {
        if (s == null)
            return null;
        if (s.length() <= 1)
            return s;
        int maxLen = 0;
        String longestStr = null;

        int length = s.length();
        int[][] table = new int[length][length];
        for (int i = 0; i < length; i++) {
            //单个单词是回文
            table[i][i] = 1;
        }
        //打印
        printTable(table);

        //aa这种回文
        for (int i = 0; i <= length - 2; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                table[i][i + 1] = 1;
                longestStr = s.substring(i, i + 2);
            }
        }
        printTable(table);

        //全部
        for (int k = 3; k <= length; k++) {
            for (int i = 0; i <= length - k; i++) {
                int j = i + k - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    table[i][j] = table[i + 1][j - 1];
                    if (table[i][j] == 1 && k > maxLen) {
                        longestStr = s.substring(i, j + 1);
                    }
                } else {
                    table[i][j] = 0;
                }
                printTable(table);
            }
        }
        return longestStr;
    }

    /**
     * 打印二维数组
     *
     * @param x
     */
    private static void printTable(int[][] x) {
        for (int[] y : x) {
            for (int z : y) {
                System.out.print(z + " ");
            }
            System.out.println();
        }
        System.out.println("-----------");
    }
}
