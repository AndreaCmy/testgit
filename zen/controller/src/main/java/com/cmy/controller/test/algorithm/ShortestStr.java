package com.cmy.controller.test.algorithm;

import java.util.Set;

/**
 * 在一个input字符串中，输出包含set中全部字符的最短字符串。如input="ardfbscjafgh" set={a,b,c}则输出结果为bscja

 * Created by mengyingc on 2017/5/2.
 */
public class ShortestStr {
    public static void occurence(String str, Set<Integer> set){
        if(str != null && !str.equals("")){
            char[] chars = str.toCharArray();
            int setLen = set.size();
            for(int i=0;i<setLen;i++){
                for(char c:chars){
                    if(set.contains(c)){

                    }
                }
            }
        }
    }

    public static void main(String[] args) {

    }
}
