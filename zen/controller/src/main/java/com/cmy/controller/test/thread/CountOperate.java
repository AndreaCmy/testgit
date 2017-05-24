package com.cmy.controller.test.thread;

/**
 * Created by AndreaChen on 2017/5/17.
 */
public class CountOperate extends Thread {
    public CountOperate(){
        System.out.println("countOperate begin");
        System.out.println(currentThread().getName() + " "+currentThread().isAlive());
        System.out.println(this.getName() +" "+ this.isAlive());
        System.out.println("countOperate end");
    }

    @Override
    public void run() {
        System.out.println("run begin");
        System.out.println(currentThread().getName()+" "+ currentThread().isAlive());
        System.out.println(this.getName()+" "+this.isAlive());
        System.out.println("run end");
    }
}
