package main.com.lwq.demo;


import java.util.Scanner;

/**
 * @Author: Lwq
 * @Date: 2018/9/24 13:54
 * @Version 1.0
 * @Describe
 */
/*
给定火柴的数量（<24），返回可以拼接的等式，
 */
public class huoChaipinjie {
    public static void main(String[] args) {
        int a,b,c,sum = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入火柴数：");
        int m = sc.nextInt();
        for( a = 0; a < 111 ; a++){
            for(b = 0; b < 111;b++){
                c = a+b;
                if(fun(a)+fun(b)+fun(c)==m-4){
                    System.out.println(a+"+"+b+"="+c);
                    sum++;
                }
            }
        }
        System.out.println("有"+sum+"种可能");
    }

    private static int fun(int x) {
        int num = 0;
        int[] arr = {6,2,5,5,4,5,6,3,7,6};
        while (x/10!=0){
            num += arr[x%10];
            x = x/10;
        }
        num += arr[x];
        return num;
    }
}
