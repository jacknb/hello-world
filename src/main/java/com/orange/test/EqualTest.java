package com.orange.test;

/**
 * Created by Administrator on 2016/10/19.
 */
public class EqualTest {
    public static void main(String[] args) {
        Boolean boo = new Boolean(true);
        String str = new String("true");
        if (boo.equals(str)) {
            System.out.println("true");
        }
    }
}
