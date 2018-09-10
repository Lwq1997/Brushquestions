package main.com.lwq.demo;


import java.util.Scanner;

/**
 * @Author: Lwq
 * @Date: 2018/9/10 10:41
 * @Version 1.0
 * @Describe
 */
/*
简单的桶排序，对100以内的n个数进行排序
 */
public class Demo04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[101];
        for(int i = 0; i < n;i++){
            arr[sc.nextInt()]++;
        }
        for(int i = 0; i < 101;i++){
            for(int j = 0; j < arr[i];j++){
                System.out.print(i+" ");
            }
        }
    }
}
