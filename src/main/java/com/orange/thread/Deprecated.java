package com.orange.thread;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2016/10/8.
 */
public class Deprecated {
    public static void main(String[] args) throws InterruptedException {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Thread printThread = new Thread(new Runner(), "PrintThread");
        printThread.setDaemon(true);
        printThread.start();
        TimeUnit.SECONDS.sleep(3);
        //suspend
        printThread.suspend();
        System.out.println("suspend at " + dateFormat.format(new Date()));
        TimeUnit.SECONDS.sleep(3);

        //resume
        printThread.resume();
        System.out.println("resume at " + dateFormat.format(new Date()));
        TimeUnit.SECONDS.sleep(3);

        //stop
        printThread.stop();
        System.out.println("stop at " + dateFormat.format(new Date()));
        TimeUnit.SECONDS.sleep(3);
    }

    static class Runner implements Runnable {

        public void run() {
            DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
            while (true) {
                System.out.println(Thread.currentThread().getName() + " run at " + dateFormat.format(new Date()));
                SleepUtils.second(1);
            }
        }
    }
}
