package main.com.lwq.wangyi;

import java.util.Scanner;

/**
 * @Author: Lwq
 * @Date: 2018/9/3 15:38
 * @Version 1.0
 * @Describe
 */
/*
小易是一个数论爱好者，并且对于一个数的奇数约数十分感兴趣。一天小易遇到这样一个问题： 定义函数f(x)为x最大的奇数约数，x为正整数。 例如:f(44) = 11.
现在给出一个N，需要求出 f(1) + f(2) + f(3).......f(N)
例如： N = 7
f(1) + f(2) + f(3) + f(4) + f(5) + f(6) + f(7) = 1 + 1 + 3 + 1 + 5 + 3 + 7 = 21
小易计算这个问题遇到了困难，需要你来设计一个算法帮助他。

输入描述:
输入一个整数N (1 ≤ N ≤ 1000000000)

输出描述:
输出一个整数，即为f(1) + f(2) + f(3).......f(N)

输入例子1:
7

输出例子1:
21
 */
/*
奇数的最大约数是自身
偶数我们只能一直除2直到得到一个奇数即为最大奇数约数
 */
public class Question14 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()){
//            int input = sc.nextInt();
//            int sum = 0;
//            for(int i = 1;i<=input;i++){
//                int temp = i;
//                while(0 == temp%2)
//                    temp /= 2;
//                sum += temp;
//            }
//            System.out.println(sum);
//        }
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            System.out.println(sum(n));
        }
    }

    private static int sum(int n) {
        if(n==1){
            return 1;
        }
        if(n%2==0){
            //sum(n)=sum(n/2)+1+3+5+7+.....
            return sum(n/2)+n*n/4;
        }else {
            return sum(n-1)+n;
        }
    }
}
