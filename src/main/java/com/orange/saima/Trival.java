package com.orange.saima;

import java.util.Scanner;

/**
 * Created by znb on 16-9-17.
 * 请设计一段程序，读取各国两两之间的距离，距离以邻接矩阵表示，并计算出遍历各国的最短路径长度。
 * 第一行：国家数量，假设为n后续n行是国家间距离的邻接矩阵表示
 * <p>
 * 遍历各国的最短路径长度
 * 4
 * 0,1,2,3
 * 1,0,4,5
 * 2,4,0,2
 * 3,5,2,0
 * 输出5
 */
public class Trival {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            //国家数量
            int n = in.nextInt();
            String[] strings = in.nextLine().split(",");
        }
    }
}
