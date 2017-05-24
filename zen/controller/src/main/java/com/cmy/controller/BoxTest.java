package com.cmy.controller;

/**
 * Created by mengyingc on 2017/5/7.
 */
public class BoxTest {
    public static void main(String[] args) {
        A a = new A();
        a.a = 1;
        a.b = 2;

        B bb = new B();
        bb.setA(a);
        bb.change();

        System.out.println(a.a+"  "+a.b);


    }

    synchronized  public void run(){}

    static class A{
        private int a;
        private int b;

        public int getA() {
            return a;
        }

        public void setA(int a) {
            this.a = a;
        }

        public int getB() {
            return b;
        }

        public void setB(int b) {
            this.b = b;
        }
    }

    static class B {
        private A a;

        public void change(){
            a.a = 3;
            a.b = 4;
        }

        public A getA() {
            return a;
        }

        public void setA(A a) {
            this.a = a;
        }
    }
}
