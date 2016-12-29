package com.orange.test;

/**
 * Created by zhuningbin on 2016/8/31.
 */
public class TestOrder {

    // 静态初始化块
    static {
        System.out.println("静态初始化块");
    }

    // 静态变量
    public static TestB b = new TestB();

    // 静态变量
    public static TestA a = new TestA();

    public static void main(String[] args) {
        new TestOrder();
    }
}

class TestA {
    public TestA() {
        System.out.println("Test---A");
    }
}

class TestB {
    public TestB() {
        System.out.println("Test---b");
    }
}
