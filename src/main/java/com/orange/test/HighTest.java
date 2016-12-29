package com.orange.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Administrator on 2016/9/5.
 */
public class HighTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();//行程天数
            int m = scanner.nextInt();//未遗失的记录数
            List<Integer> list = new ArrayList<Integer>();
            int possibleHigh = 0;
            for (int i=1;i<=m;i++){
                list.add(scanner.nextInt(),scanner.nextInt());
            }
            for (int j=1;j<=n;j++){
                int d = list.get(j);
            }
        }
    }
}
