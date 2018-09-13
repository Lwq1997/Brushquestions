package main.com.lwq.demo;

import java.util.Scanner;

/**
 * @Author: Lwq
 * @Date: 2018/9/10 11:26
 * @Version 1.0
 * @Describe
 */
/*
简单的快排
 */
public class Demo06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n;i++){
            arr[i] = sc.nextInt();
        }
        fastSort(arr,0,arr.length-1);
        for(int i = 0; i < n;i++){
            System.out.print(arr[i]+" ");
        }
    }

    private static void fastSort(int[] arr, int left, int right) {
        if (left<right){
            swap(arr, (int) (left+(Math.random()*(right-left+1))),right);
            int[] p = partition(arr,left,right);
            fastSort(arr,left,p[0]-1);
            fastSort(arr,p[1]+1,right);
        }
    }

    private static int[] partition(int[] arr, int left, int right) {
        int less = left-1;
        int more = right;
        int index = left;
        while(index<more){
            if(arr[index]<arr[right]){
                swap(arr, ++less, index++);
            }else if(arr[index]>arr[right]){
                swap(arr, --more, index);
            }else{
                index++;
            }
        }
        swap(arr, more, right);
        return new int[]{less+1,more};
    }

    private static void swap(int[] arr, int j, int i) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
