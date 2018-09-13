package main.com.lwq.demo;

import java.util.Scanner;

/**
 * @Author: Lwq
 * @Date: 2018/9/12 21:17
 * @Version 1.0
 * @Describe
 */
/*
旋转数组90
 */
public class Demo22 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int[][] arr1 = new int[n][n];
            for(int i = 0 ; i<n;i++){
                for(int j = 0; j < n;j++){
                    arr1[i][j] = sc.nextInt();
                }
            }
            revert(arr1);
            for(int i = 0 ; i<n;i++){
                for(int j = 0; j < n;j++){
                    System.out.println(arr1[i][j]);
                }
            }
        }
    }

    private static void revert(int[][] arr1) {
        int n = arr1.length;
        int tmp ;
        int limit = (n-1)/2;
        for(int i=0;i<= limit; i++){
            for(int j=i;j<n-1-i;j++){
                int temp = arr1[i][j];
                arr1[i][j] = arr1[n-1-j][i];
                arr1[n-1-j][i] = arr1[n-1-i][n-1-j];
                arr1[n-1-i][n-1-j] = arr1[j][n-1-i];
                arr1[j][n-1-i] = temp;
            }
        }
    }
}
