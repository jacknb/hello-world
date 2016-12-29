package com.orange.saima;

import java.util.Scanner;

/**
 * Created by znb on 16-9-17.
 * 假如一个数组中存储了一个股票，在一天交易窗口内各时间点的股票价格（正整数）。
 * 只允许一次买入和一次卖出，请提供一个算法，
 * 计算出通过卖出和买入可以得到的最大利润
 * 价格序列，用,号隔开
 * 最大的可能利润
 * 2,3,2,4
 * 2
 */
public class Ctrip {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            int length = 0;
            String[] strs = sc.nextLine().split(",");
            int[] prices = new int[strs.length];
            for (String str : strs) {
                prices[length++] = Integer.valueOf(str);
            }
            int max = maxProfit(prices);
            System.out.println(max);
        }
    }

    /**
     * 计算出通过卖出和买入可以得到的最大利润
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int result = 0;
        if (prices.length == 0) {
            return result;
        }
        int bought = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > bought) {
                if (result < (prices[i] - bought)) {
                    result = prices[i] - bought;
                }
            } else {
                bought = prices[i];
            }
        }
        return result;
    }
}
