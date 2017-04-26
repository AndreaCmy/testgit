package com.cmy.framework.test.thread;

/**
 * Created by mengyingc on 2017/4/19.
 */
public class DeadLock {
    public void aFirst() throws InterruptedException {
        synchronized (a){
            Thread.sleep(2000);
            synchronized (b){

                System.out.println("ThreadA");
            }
        }
    }

    public void bFirst() throws InterruptedException {
        synchronized (b){
            Thread.sleep(2000);
            synchronized (a){
                System.out.println("ThreadA");
            }
        }
    }

    private final Object a = new Object();
    private final Object b = new Object();
}
