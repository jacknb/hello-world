package com.orange.thread;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2016/10/8.
 * 安全地终止线程
 */
public class ShutDown {
    public static void main(String[] args) throws InterruptedException {
        Runner one = new Runner();
        Thread countThread = new Thread(one, "CountThread");
        countThread.start();
        TimeUnit.SECONDS.sleep(1);
        countThread.interrupt();

        Runner two = new Runner();
        countThread = new Thread(two, "CountThread");
        countThread.start();

        TimeUnit.SECONDS.sleep(1);
        two.cancle();
    }

    static class Runner implements Runnable {

        private long i;
        private volatile boolean on = true;

        public void run() {
            while (on && !Thread.currentThread().isInterrupted()) {
                i++;
            }
            System.out.println("Count i" + i);
        }

        public void cancle() {
            on = false;
        }
    }
}
