package main.com.lwq.demo;

import java.util.Scanner;

/**
 * @Author: Lwq
 * @Date: 2018/9/10 11:50
 * @Version 1.0
 * @Describe
 */
/*
快排2
 */
public class Demo07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n;i++){
            arr[i] = sc.nextInt();
        }
        quickSort(arr,0,n-1);
        for(int i = 0; i < n;i++){
            System.out.print(arr[i]+" ");
        }
    }

    private static void quickSort(int[] arr, int left, int right) {
        if(left<right){
            int i = left;
            int j = right;
            while (i!=j){
                while (arr[j]>=arr[left]&&i<j){
                    j--;
                }
                while (arr[i]<=arr[left]&&i<j){
                    i++;
                }
                if(i<j){
                    swap(arr,i,j);
                }
            }
            swap(arr,i,left);
            quickSort(arr,left,i-1);
            quickSort(arr,i+1,right);
        }
    }

    private static void swap(int[] arr, int j, int i) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
