package com.orange.wangyi;

import java.util.Scanner;

/**
 * Created by znb on 16-9-22.
 * 给定一个无向图，包含n个点、m条边，每条边是白色或者黑色，
 * 是否可以找到该图的一颗生成树，使得其中的白边条数恰好等于某一斐波纳契数(斐波纳契数列: 1, 2, 3, 5, 8, ...)?
 * <p>
 * 输入
 * 第一行一个正整数T(T<=20)，表示测试数据组数，接下来包含T组测试数据。
 * 每组测试数据第一行包含两个整数n(1<=n<=10^5)和m(0<=m<=10^5)，
 * 分别表示图中节点数和边数，接下来m行每行包含三个整数u, v, w, (1 <= u <= n, 1 <= v <= n, u不等于v, 0 <= w <= 1)
 * 表示结点u和结点v之间存在一条，w=0表示这条边为黑边，w=1表示这条边为白边。
 * <p>
 * 输出
 * 对于每一组测试数据，输出一行"Case #x: s"，x表示第x组数据，x从1开始递增，s为"Yes"或者"No"，"Yes"表示可以找到一棵符合要求的生成树，
 * 否则输出"No"，详细参见给定样例。
 */
public class FiberhomeOne {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int T = in.nextInt();
            for (int i = 1; i <= T; i++) {
                int n = in.nextInt();//节点
                int m = in.nextInt();//边
                int[][] nums = new int[m][3];

                for (int j = 0; j < m; j++) {
                    String next = in.nextLine();
                    String[] strings = next.split(" ");
                    //每行数据
                    for (int k = 0; k < 3; k++) {
                        nums[i][k] = Integer.valueOf(strings[j]);
                    }
                }
                boolean result = Fibonacci(nums, n);
                System.out.println("Case #" + i + ":" + (result == true ? "Yes" : "No"));
            }
        }
    }

    /**
     * 返回结果
     *
     * @param nums
     * @return
     */
    private static boolean Fibonacci(int[][] nums, int n) {
        int sum = 0;
        int[] parent = new int[nums.length];//是否形成环路
        for (int i = 0; i < nums.length; i++) {
            int start = nums[i][0];
            int end = nums[i][1];
            int weight = nums[i][3];

        }
        return false;
    }
}
