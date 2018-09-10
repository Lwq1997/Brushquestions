package main.com.lwq.demo;

import java.util.Scanner;

/**
 * @Author: Lwq
 * @Date: 2018/9/10 10:51
 * @Version 1.0
 * @Describe
 */
/*
简单的冒泡排序
 */
public class Demo05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n;i++){
            arr[i] = sc.nextInt();
        }
        for(int i = n-1;i>0;i--){
            for(int j = 0; j < i;j++) {
                if(arr[j]>arr[j+1]){
                    swap(arr,j,j+1);
                }
            }
        }
        for(int i = 0; i < n;i++){
            System.out.print(arr[i]+" ");
        }
    }

    private static void swap(int[] arr, int j, int i) {
        arr[i] = arr[i]^arr[j];
        arr[j] = arr[i]^arr[j];
        arr[i] = arr[i]^arr[j];
    }
}
