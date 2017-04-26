package com.cmy.framework.test.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * Created by mengyingc on 2017/4/19.
 */
public class ThreadRun {
    public static void main(String[] args) throws InterruptedException {
        DeadLock deadLock = new DeadLock();
        Thread a = new Thread(new ThreadA(deadLock));
        Thread b = new Thread(new ThreadB(deadLock));

        a.start();
        b.start();

    }
}
