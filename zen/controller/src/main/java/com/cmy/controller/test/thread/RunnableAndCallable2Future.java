package com.cmy.controller.test.thread;

import java.util.concurrent.*;

/**
 * Created by mengyingc on 2017/4/14.
 */
public class RunnableAndCallable2Future {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        try {
            Future<?> runnale1 = executorService.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("runnable running");
                }
            });
            System.out.println("runnable " + runnale1.get());

            Future<String> future1 = executorService.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    return "result = task1";
                }
            }) ;
            System.out.println("task1:" + future1.get());

            Future<String> future2 = executorService.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    try{
                        while (true){
                            System.out.println("task2 running...");
                            Thread.sleep(50);
                        }
                    }catch (InterruptedException e){
                        System.out.println("interrupted task2");
                    }
                    return "task2 = false";
                }
            }) ;
            Thread.sleep(50);
            System.out.println("task2 cancel:" + future2.cancel(true));

            Future<String> future3 = executorService.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
                      throw new Exception("task3 throw exception!");
                }
            }) ;
            System.out.println("task3:"+future3.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }
}
