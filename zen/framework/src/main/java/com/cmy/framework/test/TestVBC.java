package com.cmy.framework.test;

/**
 * 利用求差+可变字节码，对数字进行编码输出
 * 将编码后的二进制数据还原
 * Created by mengyingc on 2017/3/29.
 */
public class TestVBC {

    public String replaceSpace(StringBuffer str) {
       String s = str.toString();
       s = s.replaceAll(" ","%20");

       return s;
    }

    public static void main(String[] args) {
        TestVBC t = new TestVBC();
        System.out.println(t.replaceSpace(new StringBuffer(" ")));
    }
}
