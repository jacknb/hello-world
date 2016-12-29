package com.orange.thread;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2016/10/8.
 */
public class Interrupted {
    public static void main(String[] args) throws InterruptedException {
        //sleepThread不停的尝试睡眠
        Thread sleepThread = new Thread(new SleepRunner(), "SleepThread");
        sleepThread.setDaemon(true);

        //busyThread不停的运行
        Thread busyThread = new Thread(new BusyRunner(), "BusyThread");
        busyThread.setDaemon(true);

        sleepThread.start();
        busyThread.start();

        TimeUnit.SECONDS.sleep(5);
        sleepThread.interrupt();
        busyThread.interrupt();

        System.out.println("SleepThread interruptd is " + sleepThread.isInterrupted());
        System.out.println("BusyThread interruptd is " + busyThread.isInterrupted());

        SleepUtils.second(2);
    }

    static class SleepRunner implements Runnable {

        public void run() {
            while (true) {
                SleepUtils.second(10);
            }
        }
    }

    static class BusyRunner implements Runnable {

        public void run() {
            while (true) {

            }
        }
    }
}
