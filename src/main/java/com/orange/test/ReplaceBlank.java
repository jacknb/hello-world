package com.orange.test;

/**
 * Created by Administrator on 2016/9/15.
 * 面试题4：替换空格
 * 把空格替换成“%20”
 */
public class ReplaceBlank {
    public static void main(String[] args) {
        char[] chars = {'W', 'e', ' ', 'a', 'r', 'e', ' ', 'h', 'a', 'p', 'p', 'y', '!'};
        System.out.println(new String(ReplaceBlank(chars)));
    }

    /**
     * 把空格替换成“%20”
     *
     * @param chars 数组
     */
    public static char[] ReplaceBlank(char[] chars) {
        if (chars == null || chars.length <= 0)
            return null;
        //数组原始长度
        int originalLength = 0;
        int numberOfBlank = 0;
        //java中字符串数组边界是长度，C/C++中才是‘\0’结尾
        for (int i = 0; i < chars.length; i++) {
            ++originalLength;
            if (chars[i] == ' ')
                ++numberOfBlank;
        }

        //新数组长度
        int newLength = originalLength + numberOfBlank * 2;
        char[] newChar = new char[newLength];
        int indexOfOriginal = originalLength - 1;
        int indexOfNew = newLength - 1;
        while (indexOfOriginal >= 0 && indexOfNew >= indexOfOriginal) {
            if (chars[indexOfOriginal] == ' ') {
                newChar[indexOfNew--] = '0';
                newChar[indexOfNew--] = '2';
                newChar[indexOfNew--] = '%';
            } else {
                newChar[indexOfNew--] = chars[indexOfOriginal];
            }
            --indexOfOriginal;
        }
        return newChar;
    }
}
