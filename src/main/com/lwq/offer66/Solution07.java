package main.com.lwq.offer66;

/**
 * @Author: Lwq
 * @Date: 2018/10/11 16:09
 * @Version 1.0
 * @Describe
 */
/*
大家都知道斐波那契数列，现在要求输入一个整数n，
请你输出斐波那契数列的第n项（从0开始，第0项为0）。
n<=39
 */
public class Solution07 {
    public static void main(String[] args) {
        System.out.println(Fibonacci(2));
    }
    public static int Fibonacci(int n) {
        if(n<=0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        int fib1 = 0;
        int fib2 = 0;
        int fib3 = 1;
        for(int i = 2; i <= n ;i++){
            fib1 = fib2+fib3;
            fib2 = fib3;
            fib3 = fib1;
        }
        return fib1;
    }
}
