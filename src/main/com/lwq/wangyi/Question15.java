package main.com.lwq.wangyi;

import java.util.Scanner;

/**
 * @Author: Lwq
 * @Date: 2018/9/3 15:38
 * @Version 1.0
 * @Describe
 */
/*
小易去附近的商店买苹果，奸诈的商贩使用了捆绑交易，只提供6个每袋和8个每袋的包装(包装不可拆分)。 可是小易现在只想购买恰好n个苹果，小易想购买尽量少的袋数方便携带。如果不能购买恰好n个苹果，小易将不会购买。

输入描述:
输入一个整数n，表示小易想购买n(1 ≤ n ≤ 100)个苹果

输出描述:
输出一个整数表示最少需要购买的袋数，如果不能买恰好n个苹果则输出-1

输入例子1:
20

输出例子1:
3
 */
public class Question15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int num = sc.nextInt();
            System.out.println(count(num));
        }
    }

    private static int count(int n) {
        if(n%2!=0||n==10||n<6){
            return -1;
        }
        if(n%8==0){
            return n/8;
        }
        return 1+n/8;
    }
}
