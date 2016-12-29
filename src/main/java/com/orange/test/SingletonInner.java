package com.orange.test;

/**
 * Created by znb on 16-10-10.
 * 饿汉式单例,静态内部类
 */
public class SingletonInner {
    private static class LazyHolder {
        private static final SingletonInner instance = new SingletonInner();
    }

    private SingletonInner() {
    }

    public static final SingletonInner getInstance() {
        return LazyHolder.instance;
    }
}
