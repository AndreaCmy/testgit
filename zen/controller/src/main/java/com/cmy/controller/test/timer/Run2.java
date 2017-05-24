package com.cmy.controller.test.timer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by AndreaChen on 2017/5/18.
 */
public class Run2 {
private static   Timer timer = new Timer();
private static int runCount = 0;


    static public class MyTask extends TimerTask{
        @Override
        public void run() {
            try{
                System.out.println("begin 运行时间"+ new Date());
                Thread.sleep(2000);
                System.out.println("end 运行时间"+ new Date());
                runCount++;
                if(runCount == 5){
                    timer.cancel();
                }

            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws ParseException {
        MyTask task= new MyTask();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = sdf.parse("2017-05-18 16:53:00");
        System.out.println("当前时间："+ new Date().toString());
        timer.scheduleAtFixedRate(task, date, 3000);
    }
}
