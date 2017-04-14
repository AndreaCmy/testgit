package com.cmy.controller.test.thread;

import java.math.BigInteger;

/**
 * Created by mengyingc on 2017/4/12.
 */
public class ExpensiveFunction implements Computable<String, BigInteger> {
    public BigInteger compute(String arg){
        return new BigInteger(arg);
    }
}
