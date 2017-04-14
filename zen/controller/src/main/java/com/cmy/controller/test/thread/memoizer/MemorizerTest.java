package com.cmy.controller.test.thread.memoizer;

/**
 * Created by mengyingc on 2017/4/14.
 */
public class MemorizerTest {
    public static void main(String[] args) {
        Computable<String, Integer> computable = new ConcreteComputable<String,Integer>();
        Memoizer<String, Integer> memoizer = new Memoizer<>(computable);
    }
}
