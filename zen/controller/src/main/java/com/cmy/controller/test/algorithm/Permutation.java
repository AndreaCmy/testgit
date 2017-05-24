package com.cmy.controller.test.algorithm;

import java.util.Arrays;

/**
 * 输入一个字符串，输出字符串中字符的全排列
 * Created by mengyingc on 2017/5/1.
 */
public class Permutation {
    public static void permutation(char[] chars, int from, int to){
            if(from == to){
                System.out.println(Arrays.toString(chars));
            }else{
                for (int i = from; i <= to; i++) {
                    char temp = chars[from];
                    if (temp == chars[i] && from != i) continue;//相同的字符
                    chars[from] = chars[i];
                    chars[i] = temp;

                    permutation(chars, from + 1, to);

                    //还原数组
                     temp = chars[from];
                     chars[from] = chars[i];
                     chars[i] = temp;
                }
            }


    }

    public static void main(String[] args) {
        String str = "aac";
        char[] chars = str.toCharArray();
       permutation(chars,0 ,2);

    }
}
