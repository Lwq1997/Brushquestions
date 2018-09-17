package main.com.lwq.demo;

import java.util.Scanner;

/**
 * @Author: Lwq
 * @Date: 2018/9/15 20:48
 * @Version 1.0
 * @Describe
 */
/*
求有序矩阵中第k小元素
 */
public class Demo38 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for(int i = 0; i < n;i++){
            for(int j = 0; j < n; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(kNum(arr,k));
    }

    private static int kNum(int[][] arr, int k) {
        int n = arr.length;
        int low = arr[0][0];
        int high = arr[n-1][n-1];
        int ans = 0;
        while (low <= high) {
            int mid = (int) ((long) low + high) / 2;
            if (guess(arr, mid, k, n)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    private static boolean guess(int[][] arr, int mid, int k, int n) {

        int sum1 = 0;
        for(int i = 0; i < n; i++) {
            int low = 0;
            int high = n - 1;
            int ans = -1;
            while(low <= high) {
                int m = (low + high) / 2;
                if (arr[i][m] < mid) {
                    ans = m;
                    low = m + 1;
                } else {
                    high = m - 1;
                }
            }
            sum1 += (ans + 1);
        }

        int sum2 = 0;
        for(int i = 0; i < n; i++) {
            int low = 0;
            int high = n - 1;
            int ans = -1;
            while(low <= high) {
                int m = (low + high) / 2;
                if (arr[i][m] <= mid) {
                    ans = m;
                    low = m + 1;
                } else {
                    high = m - 1;
                }
            }
            sum2 += (ans + 1);
        }
        return k > sum1;
    }
}
