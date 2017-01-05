package com.adelmo.test;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * Created by znb on 16-10-31.
 */
public class RaidTest {
    public static void main(String[] args) {

        double result = (raid5Reliable(4, 0.95));
        DecimalFormat decimalFormat = new DecimalFormat("0.0000");

        for (int i = 1; i <= 10; i++) {
//            System.out.println(i + "->" + decimalFormat.format(Math.pow(Double.valueOf(decimalFormat.format(result)), i)));
        }

        int k;
        int s;
        int i;

        double reliable = 0.9;
        System.out.println(facRest(16, 2, 0.1));
        System.out.println(decimalFormat.format(facRest(16, 2, 0.1)));

        for (k = 4; k <= 10; k++) {
            for (s = 1; s <= 5; s++) {
                for (i = 0; i <= k * s - k; i++) {
                    System.out.println(k + ":" + s + ":" + i + ":" + decimalFormat.format(facRest(k * s, i, 1 - reliable)));
                }
            }
        }
    }

    /**
     * 计算Raid5可靠性最终计算结果
     *
     * @param m
     * @param reliable
     * @return
     */
    public static double raid5Reli(int m, double reliable) {
        return m * Math.pow(reliable, m - 1) + (1 - m) * Math.pow(reliable, m);
    }

    /**
     * 计算Raid5可靠性特定阶乘
     *
     * @param n
     * @param reliable
     * @return
     */
    public static double raid5Reliable(int n, double reliable) {
        double result;

        result = facRest(n, 4, reliable) + facRest(n, 3, reliable);
        return result;
    }

    /**
     * 计算阶乘
     *
     * @param n
     * @param num
     * @param reliable
     * @return
     */
    public static double facRest(int n, int num, double reliable) {

        double r1 = factorial(n) / (factorial(n - num) * factorial(num));
        double r2 = Math.pow(reliable, num) * Math.pow(1 - reliable, n - num);

        return format2(r1) * format2(r2);
    }


    /**
     * 计算n的阶乘
     *
     * @param n
     * @return
     */
    public static int factorial(int n) {
        int result;

        if (n <= 1) {
            result = 1;
        } else {
            result = n * factorial(n - 1);
        }
        return result;
    }

    /**
     * 使用DecimalFormat,保留小数点后4位
     *
     * @param value
     * @return
     */
    public static double format2(double value) {

        DecimalFormat df = new DecimalFormat("0.0000");
        df.setRoundingMode(RoundingMode.HALF_UP);
        return Double.parseDouble(df.format(value));
    }
}
