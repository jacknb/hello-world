package com.orange.saima;

import java.util.Scanner;

/**
 * Created by Administrator on 2016/9/16.
 * 赛码在线编程算法题
 * 将功赎过
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            //十进制范围是l~r
            int l = in.nextInt();
            int r = in.nextInt();
            //二进制m个1
            int m = in.nextInt();
            int result = 0;
            int count;
            for (int i = l; i <= r; i++) {
                //求l~r之间数的二进制，有m个1的数的个数
                count = CountOneNum(i);
                if (count == m) {
                    result++;
                }
            }
            if (result != 0) {
                System.out.println(result);
            } else {
                System.out.println(-1);
            }
        }
    }

    /**
     * 求十进制数的二进制数1的个数
     *
     * @param num
     * @return
     */
    public static int CountOneNum(int num) {
        int count = 0;
        while (num > 0) {
            if (num % 2 == 1) {
                count++;
            }
            num /= 2;
        }
        return count;
    }
}
