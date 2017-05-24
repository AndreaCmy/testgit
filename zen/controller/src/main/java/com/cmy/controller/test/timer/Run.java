package com.cmy.controller.test.timer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by AndreaChen on 2017/5/18.
 */
public class Run {

    static public class MyTask extends TimerTask{
        @Override
        public void run() {
            System.out.println("begin运行时间"+ new Date());
            System.out.println("end运行时间"+ new Date());
        }
    }

    public static void main(String[] args) throws ParseException {
        Timer timer = new Timer();
        MyTask task= new MyTask();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = sdf.parse("2017-05-18 17:32:00");
        System.out.println("当前时间："+ new Date().toString());
        timer.schedule(task, date, 3000);
    }
}
