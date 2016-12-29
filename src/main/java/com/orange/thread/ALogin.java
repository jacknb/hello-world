package com.orange.thread;

/**
 * Created by Administrator on 2016/9/30.
 */
public class ALogin extends Thread {
    @Override
    public void run() {
        LoginServlet.doPost("a", "aaa");
    }
}
