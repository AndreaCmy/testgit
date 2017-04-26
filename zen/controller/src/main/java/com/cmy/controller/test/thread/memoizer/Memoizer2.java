package com.cmy.controller.test.thread.memoizer;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;

/**
 * Created by mengyingc on 2017/4/12.
 */
public class Memoizer2<A,V> implements Computable<A,V> {
    private  final Map<A,V> cache = new ConcurrentHashMap<A, V>();
    private final Computable<A,V> c;

    public Memoizer2(Computable<A,V> c){
        this.c = c;
    }

    public  V compute(A arg) throws InterruptedException, ExecutionException {
        V result = cache.get(arg);
        if(result == null){
            result = c.compute(arg);
            cache.put(arg, result);
        }
        return  result;
    }
}
