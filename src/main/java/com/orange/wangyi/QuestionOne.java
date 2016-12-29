package com.orange.wangyi;

import java.util.Scanner;

/**
 * Created by Administrator on 2016/9/23.
 */
public class QuestionOne {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int A = in.nextInt();
        int B = in.nextInt();
        int C = in.nextInt();
        int cSum;
        int[] beSum = new int[B - A + 1];
        cSum = count(C);
        for (int i = A; i <= B; i++) {
            //求A,B之间的数位和
            beSum[i - A] = count(i);
        }
        int min = Math.abs(beSum[0] - cSum);
        for (int j = 1; j < (B - A); j++) {
            //取最小值
            if (Math.abs(beSum[j] - cSum) < min) {
                min = Math.abs(beSum[j] - cSum);
            }
        }
        System.out.println(min);

    }

    public static int count(int n) {
        int sun = 0;
        while (n != 0) {
            //C的位数和
            sun += n % 10;
            n /= 10;
        }
        return sun;
    }
}
