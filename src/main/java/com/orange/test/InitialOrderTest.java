package com.orange.test;

/**
 * Created by zhuningbin on 2016/8/31.
 */
public class InitialOrderTest {
    // 静态变量
    private static String staticField = "静态变量";
    // 变量
    private String field = "变量";

    // 静态初始化块
    static {
        System.out.println(staticField);
        System.out.println("静态初始化块");
    }

    // 初始化块
    {
        System.out.println(field);
        System.out.println("初始化块");
    }

    // 构造器
    private InitialOrderTest() {
        System.out.println("构造器");
    }

    public static void main(String[] args) {
        new InitialOrderTest();
    }
}
