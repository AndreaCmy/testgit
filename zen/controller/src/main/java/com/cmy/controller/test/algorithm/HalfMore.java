package com.cmy.controller.test.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * 查找数组中超过一半的元素：
 * 注意当标准对应的ctn=0时，需要替换标准，并将ctn重置为1
 * Created by mengyingc on 2017/4/25.
 */
public class HalfMore {

    private int[] nums;

    public HalfMore(int[] nums){
           this.nums = nums;
    }

    public static int halfMore(int[] nums){
         Map<Integer, Integer> result = new HashMap<>();
          if(nums != null && nums.length > 0){
              int c = nums[0];
              result.put(c, 1);
              for(int i = 1; i<nums.length; i++){
                  if(c == nums[i]){
                      result.put(c, result.get(c)+1);
                  }else{
                      result.put(c, result.get(c)-1);
                  }
                  if(result.get(c) == 0){
                      c = nums[i];
                      result.put(c, 1);
                  }
              }
              return c;
          }
          return -1;

    }
    public static void main(String[] args) {
          int[] nums = new int[]{1,2,3,4,1,1,2,3,1,2,1,1,1,1};
          int num = HalfMore.halfMore(nums);
          System.out.printf("num = "+num);
    }
}
