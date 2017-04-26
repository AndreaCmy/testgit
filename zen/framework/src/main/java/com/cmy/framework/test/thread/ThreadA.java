package com.cmy.framework.test.thread;

/**
 * Created by mengyingc on 2017/4/19.
 */
public class ThreadA implements Runnable{
    private DeadLock deadLock;
    @Override
    public void run() {
        try {
            deadLock.aFirst();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public ThreadA(DeadLock deadLock){
        this.deadLock = deadLock;
    }

}
