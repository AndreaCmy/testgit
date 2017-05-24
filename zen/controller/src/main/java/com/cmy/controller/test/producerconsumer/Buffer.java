package com.cmy.controller.test.producerconsumer;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * 模拟生产者消费者
 * Created by mengyingc on 2017/5/5.
 */
public class Buffer {
    private int maxSize;
    private List<Date> storage;
    Buffer(int size){
         maxSize = size;
         storage = new LinkedList<>();
    }

    //生产方法
    public synchronized  void put(){
        try{
            while(storage.size() == maxSize){
                System.out.println(Thread.currentThread().getName()+":wait \n");
                wait();
            }
            storage.add(new Date());
            System.out.println(Thread.currentThread().getName()+":put:"+storage.size()+"\n");
            Thread.sleep(1000);
            notifyAll();//唤起线程
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    //消费方法
    public synchronized void take(){
        try {
            while(storage.size() == 0){
                System.out.println(Thread.currentThread().getName()+":wait\n");
                wait();
            }
            Date d = ((LinkedList<Date>)storage).poll();
            System.out.println(Thread.currentThread().getName()+":take:"+storage.size()+"\n");
            Thread.sleep(1000);
            notifyAll();

        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }






    public static void main(String[] args) {
        Buffer buffer = new Buffer(10);
        Producer producer = new Producer(buffer);
        Consumer consumer = new Consumer(buffer);
        for(int i=0; i<3; i++){
            new Thread(producer,"producer-"+i).start();
        }

        for(int i=0; i<3; i++){
            new Thread(consumer,"consumer-"+i).start();
        }
    }
}
