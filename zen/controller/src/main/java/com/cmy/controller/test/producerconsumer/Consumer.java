package com.cmy.controller.test.producerconsumer;

/**
 * Created by mengyingc on 2017/5/5.
 */
public  class Consumer implements Runnable{
    private Buffer buffer;
    Consumer(Buffer b){
        buffer = b;
    }

    @Override
    public void run() {
        while(true){
            buffer.take();
        }
    }
}
