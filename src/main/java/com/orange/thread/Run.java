package com.orange.thread;

/**
 * Created by Administrator on 2016/9/30.
 */
public class Run {
    public static void main(String[] args) {
        /*MyThread myThread = new MyThread();
        myThread.start();
        System.out.println("The thread is stoped.");*/

        /*MyRunnable runnable = new MyRunnable();
        Thread thread = new Thread(runnable);
        thread.start();
        System.out.println("The thread stoped...");*/

        /*MyThread myThread1 = new MyThread("a");
        MyThread myThread2 = new MyThread("b");
        MyThread myThread3 = new MyThread("c");
        myThread1.start();
        myThread2.start();
        myThread3.start();*/

        /*MyThread myThread = new MyThread();
        Thread b = new Thread(myThread, "b");
        Thread c = new Thread(myThread, "c");
        Thread d = new Thread(myThread, "d");
        Thread e = new Thread(myThread, "e");
        Thread a = new Thread(myThread, "a");
        b.start();
        c.start();
        a.start();
        d.start();
        e.start();*/

        ALogin aLogin = new ALogin();
        aLogin.start();
        BLogin bLogin = new BLogin();
        bLogin.start();
    }
}
