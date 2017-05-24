package com.cmy.controller.test.algorithm;

/**
 * 2,3,5的倍数
 * Created by mengyingc on 2017/5/1.
 */
public class UglyNumber {

    public static void uglyNumber(int maxIndex){
        if(maxIndex < 0) return ;
        int[] result = new int[maxIndex];
        result[0] = 1;
        int multi2 = 0;
        int multi3 = 0;
        int multi5 = 0;
        int next = 1;
        int current = 0;

        while(next < maxIndex){
            int min = MinNumber.getMin(result[multi2]*2, result[multi3]*3,result[multi5]*5);
            result[next]  = min;

            while(multi2  < next){
                if(result[multi2]*2 <= result[next]){multi2++;}else{
                    break;
                }
            }
            while(multi3  < next){
                if(result[multi3]*3 <= result[next]){multi3++;}else{
                    break;
                }
            }
            while(multi5  < next){
                if(result[multi5]*5 <= result[next]){multi5++;}else{
                    break;
                }
            }
            next++;
        }

        System.out.println(result[maxIndex-1]);
    }
    public static void main(String[] args) {
         uglyNumber(7);//1 2 3 4 5 6 8
    }


     static class MinNumber{
         public static int getMin(int a, int b, int c){
             int min = Integer.MAX_VALUE;
             if(a < min){
                 min = a;
             }
             if(b < min) min = b;
             if(c < min) min = c;
             return min;
         }
    }
}
