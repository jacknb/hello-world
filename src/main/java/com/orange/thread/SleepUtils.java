package com.orange.thread;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2016/10/8.
 */
public class SleepUtils {
    public static final void second(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
        }
    }
}
