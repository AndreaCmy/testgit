package com.cmy.controller.test.algorithm;

/**
 * Created by mengyingc on 2017/5/5.
 */
public class MergeSort {
    public static void main(String[] args) {
      int[] arr = new int[]{10,2,32,3,80,22,12,76};
        System.out.println("排序前");
      print(arr);
        System.out.println("排序中");
      mergeSort(arr);
        System.out.println("排序后");
      print(arr);
    }

    public static void print(int[] arr){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+ ">>");
        }
        System.out.println();
    }

    public static void mergeSort(int[] arr){
           sort(arr,0,arr.length-1);
    }

    public static void sort(int[] arr, int from, int to){
        if(from >= to) return;
        int mid = (to+from)/2; //求中间值
        sort(arr, from, mid);
        sort(arr,mid+1, to);
        merge(arr,from, mid, to);
        print(arr);
    }


    public static void merge(int[] arr, int left, int mid, int right){
        int size = arr.length;
        int[] result = new int[size];//临时数组
        int k=left;//临时数组索引
        int i=left,j=mid+1;
        while(i<=mid && j<=right){
            if(arr[i] <= arr[j]){
                result[k++] = arr[i++];
            }else{
                result[k++] = arr[j++];
            }
        }

        //剩余的部分
        while(i<=mid){
            result[k++] = arr[i];
            i++;
        }
        while(j<=right){
            result[k++] = arr[j];
            j++;
        }

        //将临时数组拷贝回原数组
        for(i=left; i<=right; i++){
            arr[i] = result[i];
        }
    }
}
