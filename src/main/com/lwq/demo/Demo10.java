package main.com.lwq.demo;

import java.util.Scanner;

/**
 * @Author: Lwq
 * @Date: 2018/9/10 17:12
 * @Version 1.0
 * @Describe
 */
/*
简单的二维数组的输入输出
 */
public class Demo10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int row = sc.nextInt();
            int col = sc.nextInt();
            int[][] arr = new int[row+1][col+1];
            for(int i = 1; i <= row;i++){
                for(int j = 1; j <= col;j++){
                    arr[i][j] = sc.nextInt();
                }
            }
            for(int i = 1; i <= row;i++){
                for(int j = 1; j <= col;j++){
                    System.out.print(arr[i][j]+" ");
                }
                System.out.println();
            }
        }
    }
}
