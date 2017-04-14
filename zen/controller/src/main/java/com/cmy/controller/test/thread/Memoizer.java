package com.cmy.controller.test.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

/**
 * Created by mengyingc on 2017/4/12.
 */
public class Memoizer<A,V> implements Computable<A,V> {
    private  final Map<A,Future<V>> cache = new ConcurrentHashMap<A, Future<V>>();
    private final Computable<A,V> c;

    public Memoizer(Computable<A,V> c){
        this.c = c;
    }

    public  V compute(A arg) throws InterruptedException, ExecutionException {
        while(true){
            Future<V> future = cache.get(arg);
            if(future == null){
                Callable<V> eval = new Callable<V>() {
                    @Override
                    public V call() throws Exception {
                        return c.compute(arg);
                    }
                };
                FutureTask<V> futureTask = new FutureTask<V>(eval);
                future = cache.putIfAbsent(arg, futureTask);
                if(future == null){
                    future = futureTask;
                    futureTask.run();
                }
            }
            try {
                return future.get();
            }catch (CancellationException e){
                cache.remove(arg, future);
            }catch (ExecutionException e){
                throw  e;
            }

        }
    }
}
