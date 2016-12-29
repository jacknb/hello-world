package com.orange.thread;

/**
 * Created by Administrator on 2016/9/30.
 */
public class BLogin extends Thread {
    @Override
    public void run() {
        LoginServlet.doPost("b", "bbb");
    }
}
