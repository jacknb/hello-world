package com.orange.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by zhuningbin on 2016/9/12.
 */
public class Wangyi1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            //需要的颜色种数n
            int n = in.nextInt();
            //需要的各种颜料
            List<Integer> need = new ArrayList<Integer>();
            for (int i = 0; i < n; i++) {
                need.add(i, in.nextInt());
            }
            
        }
    }
}
