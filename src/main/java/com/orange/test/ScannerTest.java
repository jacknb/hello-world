package com.orange.test;

import java.util.Scanner;

/**
 * Created by Administrator on 2016/9/4.
 */
public class ScannerTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int one = scanner.nextInt();
            int two = scanner.nextInt();
            System.out.println(one);
            System.out.println(two);
        }
    }
}
