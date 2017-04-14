package com.cmy.controller.test.thread.memoizer;

import java.util.concurrent.ExecutionException;

/**
 * Created by mengyingc on 2017/4/14.
 */
public class ConcreteComputable<A, V> implements Computable<A, V> {

    @Override
    public V compute(A arg) throws InterruptedException, ExecutionException {
        return null;
    }
}
