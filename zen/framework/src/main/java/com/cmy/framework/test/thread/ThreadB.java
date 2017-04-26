package com.cmy.framework.test.thread;

/**
 * Created by mengyingc on 2017/4/19.
 */
public class ThreadB implements Runnable{
    private DeadLock deadLock;
    @Override
    public void run() {
        try {
            deadLock.bFirst();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public ThreadB(DeadLock deadLock){
        this.deadLock = deadLock;
    }
}
