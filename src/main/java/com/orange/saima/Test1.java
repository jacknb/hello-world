package com.orange.saima;

import java.util.Scanner;

/**
 * Created by Administrator on 2016/9/16.
 * 赛码在线编程算法题
 * 股神
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            int result = 1;
            int position = 2;
            int blank = 3;
            for (int i = 1; i < n; i++) {
                if (i == position) {
                    //涨幅的最后一天
                    result--;
                    //新的涨幅间隔
                    position = position + blank;
                    blank++;
                } else {
                    result++;
                }
            }
            System.out.println(result);
        }
    }
}
