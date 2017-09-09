package com.orange.bignum;

import java.util.Arrays;

/**
 * Created by znb on 17-9-8.
 * 大数加、减、乘、除、取模运算
 */
public class BigNumber {

    public static void main(String[] args) {
        String strNum1 = "232091389120839021830912839012839012";
        String strNum2 = "9890283019283100012313123123131231312312";
        char[] charNum1 = strNum1.toCharArray();
        char[] charNum2 = strNum2.toCharArray();
        int[] temp = doMul(charNum1, charNum2);
        String result;
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < temp.length; i++) {
            stringBuilder.append(temp[i]);
        }

        result = String.valueOf(stringBuilder);

        System.out.println("Result: " + result);
    }

    public static int[] doMul(char[] charNum1, char[] charNum2) {
        int[] result = new int[charNum1.length + charNum2.length - 1];
        int[] begint = new int[charNum1.length];
        int[] end = new int[charNum2.length];
        int[][] tmp = new int[charNum1.length][charNum2.length];

        for (int i = 0; i < charNum1.length; i++) {
            //char转int为ASCII值
            begint[i] = Integer.valueOf(charNum1[i] + "");
        }

        for (int j = 0; j < charNum2.length; j++) {
            end[j] = Integer.valueOf(charNum2[j] + "");
        }

        for (int i = 0; i < charNum1.length; i++) {
            for (int j = 0; j < charNum2.length; j++) {
                //将数一位一位相乘
                tmp[i][j] = begint[i] * end[j];
            }
        }
        int k = 0;
        while (k < charNum1.length + charNum2.length - 1) {
            for (int i = 0; i < charNum1.length; i++) {
                for (int j = 0; j < charNum2.length; j++) {
                    if (i + j == k) {
                        //各列数相加
                        result[k] += tmp[i][j];
                    }
                }
            }
            k++;
        }

        for (int i = charNum1.length + charNum2.length - 1 - 1; i > 0; i--) {
            if (result[i] > 9) {
                result[i - 1] += result[i] / 10;
                result[i] = result[i] % 10;
            }
        }
        return result;
    }
}
