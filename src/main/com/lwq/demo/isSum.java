package main.com.lwq.demo;

/**
 * @Author: Lwq
 * @Date: 2018/9/21 17:22
 * @Version 1.0
 * @Describe
 */
/*
给定一个数组和一个数，看看数组中的数能否加出目标数，如果能，返回true，否则，返回false
 */
public class isSum {
    public static void main(String[] args) {
        int[] arr = {2,7,8};
        int aim = 9;
        System.out.println(issum1(arr,0,0,aim));
        System.out.println(issum2(arr,aim));
    }

    private static boolean issum2(int[] arr, int aim) {
        boolean[][] dp = new boolean[arr.length+1][aim+1];
        for(int i = 0; i < dp.length ; i++){
            dp[i][aim] = true;
        }
        for(int i = arr.length-1 ; i >= 0; i--){
            for(int j = aim-1 ; j >=0; j--){
                if(j+arr[i]<=aim){
                    dp[i][j] = dp[i+1][j]||dp[i+1][j+arr[i]];
                }
            }
        }
        for(int i = 0;i < dp.length ; i++){
            for(int j = 0; j < dp[0].length ; j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        return dp[0][0];
    }

    private static boolean issum1(int[] arr, int i, int sum, int aim) {
        if(i == arr.length){
            return sum==aim;
        }
        return issum1(arr,i+1,sum,aim)||issum1(arr,i+1,sum+arr[i],aim);
    }
}
