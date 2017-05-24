package com.cmy.controller.test.algorithm;

import java.util.Stack;

/**
 * 是否是正确的进出栈顺序
 * Created by mengyingc on 2017/4/28.
 */
public class StackPushPop {

    public static boolean possibleOrder(int[] origin, int[] order){
        boolean possible = false;
        Stack<Integer> helper = new Stack<>();//辅助栈
        int pop = 0;//stack到order出栈的指针
        int push = 0;//origin到stack入栈的指针
        int length = order.length;
        while(pop < length){
            while(helper.isEmpty() || helper.peek() != order[pop]){
                //所有元素都入栈了
                if(push == length){
                    break;
                }
                helper.push(origin[push]);
                push++;
            }
            if(helper.peek() == order[pop]){
                //1.栈顶元素等于目标元素
                helper.pop();
                pop++;
            }else{
                //2.此处说明stack已经空了，但是helper不为空
                possible = false;
                break;
            }


        }
        if(helper.isEmpty() ){
            possible = true;//正确的序列
        }
        return possible;
    }
    public static void main(String[] args) {
        //输入 【1,2,3,4,5】 【4,5,3,2,1】 ,输出 true
        //输入 【1,2,3,4,5】 【4,5,3,1,2】 ,输出 false
        Stack<Integer> stack = new Stack<>();
        for(int i=1; i<=5; i++){
            stack.push(i);
        }

        int[] origin = new int[]{1,2,3,4,5};
        int[] order1 = new int[]{4,5,3,2,1};
        int[] order2 = new int[]{4,5,3,1,2};

        System.out.println(possibleOrder(origin, order1));
        System.out.println(possibleOrder(origin, order2));
    }
}
