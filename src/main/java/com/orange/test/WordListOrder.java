package com.orange.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/12.
 */
public class WordListOrder {
    public static void main(String[] args) {
        String[] arr = new String[]{"abcd", "defg", "ghij", "rkl"};
        int result = canArrangeWords(arr);
        System.out.println(result);
    }

    public static int canArrangeWords(String arr[]) {
        // INSERT YOUR CODE HERE
        List<String> begin = new ArrayList<String>();
        List<String> end = new ArrayList<String>();
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                //第一个数组的第一个单词
                end.add(i, String.valueOf(arr[i].charAt(arr[i].length() - 1)));
            } else if (i == arr.length - 1) {
                //最后一个数组的最后一个单词
                begin.add(i - 1, String.valueOf(arr[i].charAt(0)));
            } else {
                begin.add(i - 1, String.valueOf(arr[i].charAt(0)));
                end.add(i, String.valueOf(arr[i].charAt(arr[i].length() - 1)));
            }
        }
        if (begin.equals(end)) {
            return 1;
        }
        return -1;
    }

}
