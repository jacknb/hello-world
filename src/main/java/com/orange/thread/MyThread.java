package com.orange.thread;

/**
 * Created by Administrator on 2016/9/30.
 */
public class MyThread extends Thread {

    private int count = 5;

    /*public MyThread(String name) {
        super();
        this.setName(name);
    }*/

    @Override
    synchronized public void run() {
        super.run();
        count--;
        System.out.println("由 " + this.currentThread().getName() + " 计算，count=" + count);
    }
}
