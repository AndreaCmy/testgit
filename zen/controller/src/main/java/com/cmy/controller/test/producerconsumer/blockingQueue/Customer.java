package com.cmy.controller.test.producerconsumer.blockingQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by mengyingc on 2017/5/9.
 */
public class Customer implements Runnable {
    private BlockingQueue<String> queue;

    public Customer(BlockingQueue<String> queue){
        this.queue = queue;
    }



    @Override
    public void run() {
        while(!Thread.currentThread().isInterrupted()){
            try{
                System.out.println("got: " + queue.take());
            }catch (InterruptedException e){
                e.printStackTrace();
            }

            try{
                TimeUnit.MILLISECONDS.sleep(10);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
