package com.orange.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Administrator on 2016/9/4.
 */
public class QueryTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            List<Integer> list = new ArrayList<Integer>();
            list = getPerm(list, n);
            int j = 0;
            while (j < list.size() - 1) {
                System.out.print(list.get(j) + " ");
                j++;
            }
            System.out.println(list.get(list.size() - 1));
        }
    }

    private static List<Integer> getPerm(List<Integer> list, int n) {
        int tmp;
        while (n > 0) {
            list.add(0, n);
            tmp = list.remove(list.size() - 1);
            list.add(0, tmp);
            n--;
        }
        return list;
    }
}
