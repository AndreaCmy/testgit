package com.cmy.controller.test.thread;

/**
 * Created by mengyingc on 2017/4/12.
 */
public class TaskRunable implements Runnable {

    @Override
    public void run() {
        try{

                System.out.println("do work...");
                Thread.sleep(1000);
        }catch (InterruptedException e){
            //jvm会清除中断标记
            System.out.println("after catch exception:"+Thread.currentThread().isInterrupted());
            Thread.currentThread().interrupted();
            System.out.println("after set interupt:" + Thread.currentThread().isInterrupted());
        }
    }
}
