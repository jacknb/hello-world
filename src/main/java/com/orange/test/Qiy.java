package com.orange.test;

import java.util.Scanner;

/**
 * Created by znb on 16-9-18.
 * 爱奇艺编程题
 * 会员成长值=每天成长值+任务成长值
 */
public class Qiy {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] nums = new int[1000];
        while (in.hasNextLine()) {
            String next = in.nextLine();
            String[] strings = next.split(" ");
            int[] s = new int[nums.length];
            for (int i = 0; i < strings.length; i++) {
                s[i] = Integer.valueOf(strings[i]).intValue();
            }

            if (s[0] == 1) {
                for (int i = s[1]; i <= s[2]; i++) {
                    if (nums[i] < s[3]) {
                        nums[i] = s[3];
                    }
                }
            } else if (s[0] == 2) {
                nums[s[1]] = nums[s[1]] + s[2];
            }
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
        }
        System.out.println(sum);
    }
}
