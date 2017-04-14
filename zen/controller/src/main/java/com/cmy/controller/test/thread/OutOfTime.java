package com.cmy.controller.test.thread;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Created by mengyingc on 2017/4/13.
 */
public class OutOfTime {
    public static void main(String[] args) throws InterruptedException {
        Timer timer = new Timer();
        timer.schedule(new ThrowTask1(),1);
//        SECONDS.sleep(1);
        timer.schedule(new ThrowTask2(),1);
//        SECONDS.sleep(5);
    }

    static class ThrowTask1 extends TimerTask{
        @Override
        public void run() {
            try {
                System.out.println("start task1:"+new Date());
                Thread.sleep(5000);
                System.out.println("end task1:"+new Date());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class ThrowTask2 extends TimerTask{
        @Override
        public void run() {
            try {
                System.out.println("start task2:"+new Date());
                Thread.sleep(5000);
                System.out.println("end task2:"+new Date());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
