package com.adelmo.hadoop.test;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * Created by znb on 16-10-31.
 */
public class Main {
    public static void main(String[] args) {
//        System.out.println(Math.pow(0.5, 2));
//        System.out.println(raid5Reliable(4, 0.9));

        double result = (raid5Reliable(4, 0.95));
        DecimalFormat decimalFormat = new DecimalFormat("0.0000");

        for (int i = 1; i <= 10; i++) {
//            System.out.println(decimalFormat.format(result));
            System.out.println(i + "->" + decimalFormat.format(Math.pow(Double.valueOf(decimalFormat.format(result)), i)));
        }

        for (int i=2;i<=8;i++){
            for (int j=2;j<=6;j++){
                System.out.println(j+"-->"+decimalFormat.format());
            }
        }
    }

    /**
     * 计算Raid5可靠性最终计算结果
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

    public static double facRest(int n, int num, double reliable) {
        return (Math.pow(reliable, num) * Math.pow(1 - reliable, n - num)) * (factorial(n) / (factorial(n - num) * factorial(num)));
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
     * 使用DecimalFormat,保留小数点后两位
     *
     * @param value
     * @return
     */
    public static String format2(double value) {

        DecimalFormat df = new DecimalFormat("0.0000");
        df.setRoundingMode(RoundingMode.HALF_UP);
        return df.format(value);
    }
}
