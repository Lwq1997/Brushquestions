package main.com.lwq.demo;

/**
 * @Author: Lwq
 * @Date: 2018/9/13 16:59
 * @Version 1.0
 * @Describe
 */
/*
给定一个数组和一个数，小于这个数放左边，等于这个数放中间，大于这个数放右边
 */
public class Demo27 {
    public static void main(String[] args) {
        int[] arr = new int[]{9,6,3,2,1,5,8,5,1,3,4};
        int k = 5;
        method(arr,k);

        for(int i = 0; i < arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    private static void method(int[] arr, int k) {
        int less = -1;
        int more = arr.length;
        int index = 0;
        while (index<more){
            if(arr[index]<k){
                swap(arr,++less,index++);
            }else if(arr[index]>k){
                swap(arr,index,--more);
            }else {
                index++;
            }
        }
    }

    private static void swap(int[] arr, int i, int more) {
        int tem = arr[i];
        arr[i] = arr[more];
        arr[more] = tem;
    }

}
