package com.orange.test;

/**
 * Created by znb on 16-10-10.
 * 懒汉模式，单例模式
 */
public class Singleton {
    private Singleton() {
    }

    private static Singleton instance = null;

    public synchronized static Singleton getInstance() {
        //静态工厂方法
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    //双重检查锁定
    public static Singleton getInstance1() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
