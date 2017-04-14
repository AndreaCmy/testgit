package com.cmy.controller.test.thread;

/**
 * Created by mengyingc on 2017/4/12.
 */
public class Test {

    public static void main(String[] args) {
       TaskRunable taskRunable = new TaskRunable();
        Thread t  = new Thread(taskRunable);
        t.start();

        System.out.println("interrupted");
        t.interrupt();

    }
}
