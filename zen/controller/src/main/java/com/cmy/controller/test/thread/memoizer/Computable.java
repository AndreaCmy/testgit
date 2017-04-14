package com.cmy.controller.test.thread.memoizer;

import java.util.concurrent.ExecutionException;

/**
 * Created by mengyingc on 2017/4/12.
 */
public interface Computable<A, V> {
  V compute(A arg) throws InterruptedException, ExecutionException;
}
