package com.orange.test;

/**
 * Created by Administrator on 2016/9/13.
 */
public class PerfectNumber {
    public static void main(String[] args) {
        int i = 1, j = 10;
        do {
            if (i++ > --j)
                continue;
        } while (i < 5);
        System.out.println(i + " ," + j);
    }

    public static int perfectNumberCheck(int n) {
        // Check if N is perfect or not
        // Return 1 or 0
        // INSERT YOUR CODE HERE
        String a = "a";
        return 1;
    }
}
