package com.cmy.controller.test.algorithm;

import java.util.Arrays;

/**
 * Created by mengyingc on 2017/4/27.
 */
public class FastSort {


    public static void fastSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int base = nums[0];
        int head = 0;
        int tail = nums.length - 1;
        oneRoadSort(nums, head, tail);
        System.out.println(Arrays.toString(nums));
    }

    public static int partition(int[] nums, int from, int to) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (from < to) {
            int head = from;
            int tail = to;
            int base = nums[from];
            while (head < tail) {
                while (head < tail && nums[tail] >= base) {
                    tail--;
                }
                while (head < tail && nums[head] <= base) {
                    head++;
                }
                if (tail != head) {
                    nums[tail] = nums[tail] ^ nums[head];
                    nums[head] = nums[head] ^ nums[tail];
                    nums[tail] = nums[tail] ^ nums[head];
                    tail--;
                    head++;
                }
            }
            nums[from] = nums[head];
            nums[head] = base;
            return head;
        }else{
            return 0;
        }
    }

    //一趟排序，保证基准最终有序

    public static void oneRoadSort(int[] nums, int from, int to) {
        if (from < to) {
            int mid = partition(nums, from, to);
            //左边
           oneRoadSort(nums, from, mid - 1);
            //右边
            oneRoadSort(nums, mid + 1, to);
        }
    }

    public static void main(String[] args) {

        int[] nums = new int[]{1, 22, 13, 4, 2, 8, 3};
        System.out.println(Arrays.toString(nums));
        FastSort.fastSort(nums);
    }
}
