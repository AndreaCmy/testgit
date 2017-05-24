package com.cmy.controller.test.algorithm;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 把数组排成最小数
 * 大树转换成字符串处理
 * Created by mengyingc on 2017/5/1.
 */
public class MinNumber {

    public static void minNumber(int[] nums){
      if(nums != null){
          String[] strArr = new String[nums.length];
          for(int i=0 ; i< nums.length; i++){
              String str = ""+nums[i];
              strArr[i] = str;
          }
          Arrays.sort(strArr, new Comparator<String>() {
              @Override
              public int compare(String o1, String o2) {
                  if(o1.length() > o2.length()) return 1;
                  else if(o1.length() < o2.length()) return -1;
                  else {
                      char[] chars1 = o1.toCharArray();
                      char[] chars2 = o2.toCharArray();
                      for(int i=0; i<chars1.length; i++){
                          if(chars1[i] == chars2[i]){
                              continue;
                          }else if(chars1[i] > chars2[i]) return 1;
                          else return -1;
                      }
                      return 0;
                  }
              }
          });

          for(String s :strArr){
              System.out.print(s);
          }
      }

    }
    public static void main(String[] args) {
        int[] nums = new int[]{3,320,321};
        minNumber(nums);
    }
}
