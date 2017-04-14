package com.cmy.controller.test;

/**
 * Created by mengyingc on 2017/4/14.
 */
public class TestFinally {
    public static void main(String[] args) {

        System.out.println(test4());
    }

    public static int test4() {
        int b = 20;

        try {
            System.out.println("try block");

            b = b / 0;

            return b += 80;
        } catch (Exception e) {

            System.out.println("catch block");
            b += 15;
        } finally {

            System.out.println("finally block");

            if (b > 25) {
                System.out.println("b>25, b = " + b);
            }

            b += 50;
        }

        return 204;
    }

}
