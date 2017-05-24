package com.cmy.controller.test.thread.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * Created by AndreaChen on 2017/5/12.
 */
public class ForkJoinTask  extends RecursiveTask<Integer>{
      private static final int THRESHOLD = 2;
      private int start;
      private int end;

      public ForkJoinTask(int start, int end){
          this.start = start;
          this.end = end;
      }
        @Override
        protected Integer compute() {
          int sum = 0;
          boolean canCompute = end - start <= THRESHOLD;
          if(canCompute){
              for(int i=start; i<=end;i++){
                  sum+=i;
              }
          }else{
              int mid = (start+end)/2;
              ForkJoinTask left = new ForkJoinTask(start, mid-1);
              ForkJoinTask right = new ForkJoinTask(mid,end);
              left.fork();
              right.fork();

              int leftResult = left.join();
              int rightResult = right.join();
              sum = leftResult + rightResult;
          }
            return sum;
        }


    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask task = new ForkJoinTask(1,4);
        Future<Integer> result = forkJoinPool.submit(task);
        try {
            System.out.println(result.get());
        }catch (Exception e){

        }
    }

}
