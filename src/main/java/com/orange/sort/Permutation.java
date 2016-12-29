package com.orange.sort;

/**
 * Created by Administrator on 2016/10/26.
 * 输出一个字符串的全排列(有无重复字符均可)
 * 如abc输出为
 * abc,acb,bac,bca,cab,cba
 */
public class Permutation {

    public static void main(String[] args) {
        String str = "abc";
        permutation(str.toCharArray(), 0);
    }

    /**
     * 递归实现全排列
     *
     * @param chars
     * @param i
     */
    private static void permutation(char[] chars, int i) {
        if (i > chars.length)
            return;
        if (i == chars.length) {
            System.out.println(String.valueOf(chars));
        } else {
            for (int j = i; j < chars.length; j++) {

                if (isSwap(chars, i, j)) {
                    //字母交换
                    swap(chars, i, j);

                    //递归调用
                    permutation(chars, i + 1);

                    //字母换回
                    swap(chars, i, j);
                }
            }
        }
    }

    /**
     * 交换两个字符
     *
     * @param chars
     * @param i
     * @param j
     */
    private static void swap(char[] chars, int i, int j) {
        char temp = chars[j];
        chars[j] = chars[i];
        chars[i] = temp;
    }

    /**
     * 判断是否需要交换
     *
     * @param chars
     * @param begin
     * @param k
     * @return
     */
    private static boolean isSwap(char[] chars, int begin, int k) {
        boolean flag = true;
        for (int i = begin; i < k; i++) {
            if (chars[i] == chars[k]) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}
