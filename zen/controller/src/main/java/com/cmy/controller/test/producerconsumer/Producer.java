package com.cmy.controller.test.producerconsumer;

/**
 * Created by mengyingc on 2017/5/5.
 */
public  class Producer implements Runnable{
    private Buffer buffer;
    Producer(Buffer b){
        buffer = b;
    }

    @Override
    public void run() {
        while(true){
            buffer.put();
        }
    }
}
