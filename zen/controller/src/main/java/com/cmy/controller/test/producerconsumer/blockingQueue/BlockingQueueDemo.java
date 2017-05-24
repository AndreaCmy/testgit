package com.cmy.controller.test.producerconsumer.blockingQueue;

import com.cmy.controller.test.producerconsumer.blockingQueue.Customer;
import com.cmy.controller.test.producerconsumer.blockingQueue.Producer;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by mengyingc on 2017/5/9.
 */
public class BlockingQueueDemo {
    public static void main(String[] args) {
        BlockingQueue<String> queue =  new ArrayBlockingQueue<String>(10);
        Thread t1 = new Thread(new Producer(queue, 500, "apple"));
        Thread t2 = new Thread(new Customer(queue));
        t1.start();
        t2.start();
    }
}
