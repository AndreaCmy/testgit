package com.cmy.controller.test;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by mengyingc on 2017/5/4.
 */
public class TestInterator {

    public static void forList(List<Integer> a){
     for(int i=0; i<a.size();i++){
         if(a.get(i) < 20){
             a.remove(i);
             i--;
         }
     }
        System.out.println(a.toString());
    }

    public static void forEachList(List<Integer> a){
       for(Integer x:a){
           if(x < 20){
               a.remove(x);
           }
       }
        System.out.println(a.toString());
    }

    public static void iterator(List<Integer> a){

        Iterator it = a.iterator();
        while(it.hasNext()){
            if((Integer)it.next() < 20){
              it.remove();
            }
        }

        System.out.println(a.toString());

    }
    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        for(int i=0; i<10;i++){
            a.add(i*10);
        }

         //forList(a);
        forEachList(a);
        iterator(a);
    }


}
