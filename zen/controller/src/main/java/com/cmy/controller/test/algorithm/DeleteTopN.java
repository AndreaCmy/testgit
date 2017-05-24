package com.cmy.controller.test.algorithm;

import java.util.Stack;

/**
 * Created by mengyingc on 2017/5/2.
 */
public class DeleteTopN {
    public static void popTopN(int[] arr){
        if(arr != null){
            Stack stack = new Stack<Integer>();
            Stack helper = new Stack<Integer>();
            for(int i=0; i<arr.length;i++){
                int max = arr[i];
                stack.push(max);
                if(helper.isEmpty() || max >= (Integer)helper.peek()){
                   helper.push(max);
                }else{
                    helper.push(helper.peek());
                }
            }//end for

            while(!stack.isEmpty()){
                System.out.println(stack.pop() + "出栈"+",max="+helper.pop());
            }
        }

    }
    public static void main(String[] args) {
        int[] arr = new int[]{5,4,2,1,10,8,9};
        popTopN(arr);
    }
}
