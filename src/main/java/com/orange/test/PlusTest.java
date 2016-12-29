package com.orange.test;

/**
 * Created by zhuningbin on 2016/9/1.
 */
public class PlusTest {
    public static void main(String[] args) {
        int i = 0;
        int j = i++ + ++i;
        int k = i-- + --i;
        System.out.println(i);
        System.out.println(j);
        System.out.println(k);

        int a = 0;
        System.out.println(a++);
        fib(8);
        System.out.println(cnt);
    }

    static int cnt = 0;

    private static int fib(int n) {

        cnt++;
        if (n == 0)
            return 1;
        else if (n == 1)
            return 2;
        else
            return fib(n - 1) + fib(n - 2);
    }

}
