package com.cmy.framework.test;

import javax.annotation.Resource;

/**
 * Created by mengyingc on 2017/4/18.
 */
public class Singleton {
    Singleton(){
        System.out.println("Singleton");
    }
     private static class  ResourceHolder{
         static {
             System.out.println("ResourceHolder");
         }
         public  static Holder resource = new Holder();
     }

     public static Holder getResource(){
         System.out.println("getResource");
         return ResourceHolder.resource;
     }

    public static void main(String[] args) {
        Singleton.getResource();
    }
}
