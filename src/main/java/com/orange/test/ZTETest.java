package com.orange.test;

/**
 * Created by zhuningbin on 2016/9/8.
 * 输入3，打印如下：
 * 1*2*3*10*11*12
 * --4*5*8*9
 * ----6*7
 */
public class ZTETest {
    public static void main(String[] args) {

    }

    public static void printNum(int n) {
        //记录数字
        int num = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < num; j++) {
                //每行打印2(n-1)个-
                if (j < i - 1) {
                    System.out.print("-");
                }
                if (j <= n) {
                    System.out.print(j + "*");
                } else {
                    for (int k = n * n; k < n * (n + 1); k++) {
                        System.out.print(k + "*");
                    }
                    System.out.print(n * (n + 1));
                }
            }
        }
    }
}
