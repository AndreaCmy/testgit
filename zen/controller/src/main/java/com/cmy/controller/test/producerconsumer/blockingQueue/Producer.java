package com.cmy.controller.test.producerconsumer.blockingQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by mengyingc on 2017/5/9.
 */
public class Producer implements Runnable {
    private BlockingQueue<String> queue;
    private int timeout;//生产一个产品后暂停的时间
    private String p;
    public Producer(BlockingQueue<String> queue, int timeout, String p){
        this.queue = queue;
        this.timeout = timeout;
        this.p = p;
    }



    @Override
    public void run() {
       while(!Thread.currentThread().isInterrupted()){
           try{
               queue.put("product"+p);
           }catch (InterruptedException e){
               e.printStackTrace();
           }

           try{
               TimeUnit.MILLISECONDS.sleep(timeout);
           }catch (InterruptedException e){
               e.printStackTrace();
           }
       }
    }
}
