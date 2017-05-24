package com.cmy.controller.test.thread;

/**
 * Created by mengyingc on 2017/4/12.
 */
public class Test {

    public static void main(String[] args) {
      CountOperate c = new CountOperate();
      Thread t = new Thread(c);
      t.setName("A");
      t.start();

    }
}
