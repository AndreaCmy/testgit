package com.cmy.controller.test.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by mengyingc on 2017/4/26.
 * 将空格替换成%20
 */
public class ReplaceSpace {

    public static void replaceSpace(String str){


        if(str != null && !str.isEmpty()){
            System.out.println("输入字符串："+str +">>"+str.length());
            char[] chars = str.toCharArray();
            int len = chars.length;
            //1.计算出空格的个数 n
            int spaceCtn = 0;
            for(int i = 0; i<len; i++){
                if(Character.isSpaceChar(chars[i])){
                     spaceCtn++;
                }
            }
            //2.替换后的字符串长度 = len + n*2
            int newLen = len + 2*spaceCtn;
            System.out.println("len="+len);
            System.out.println("spaceCtn="+spaceCtn);
            System.out.println("newLen="+newLen);
            //3.将字符串复制到新的数字中，从后往前复制，遇到空格，将空格替换成%20
            char[] newChars = new char[newLen];
            for(int i = 0; i<len; i++){
                newChars[i] = chars[i];
            }
            int from = len - 1;
            int to = newLen - 1;
            while (from < to){
                while(!Character.isSpaceChar(newChars[from])){ //非空字符直接复制
                    newChars[to] = newChars[from];
                    to--;
                    from--;
                }
                if(Character.isSpaceChar(newChars[from])){//空字符需要替换成%20
                    newChars[from++] = '%';
                    newChars[from++] = '2';
                    newChars[from++] = '0';
                }
                from--;//from指向当前可复制的起始位置

            }

            System.out.println("输出字符串：");
            for(int i=0; i<newLen; i++){
                System.out.print(newChars[i]);
            }
            System.out.println();
        }


    }
    public static void main(String[] args) {
        ReplaceSpace.replaceSpace("");
        ReplaceSpace.replaceSpace("  ");
        ReplaceSpace.replaceSpace(" hello ");
        ReplaceSpace.replaceSpace(" hello world ");

    }
}
