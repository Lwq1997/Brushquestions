package main.com.lwq.wangyi;

import java.util.Scanner;

/**
 * @Author: Lwq
 * @Date: 2018/9/1 15:54
 * @Version 1.0
 * @Describe
 */
/*
小易有一个长度为N的正整数数列A = {A[1], A[2], A[3]..., A[N]}。
牛博士给小易出了一个难题:
对数列A进行重新排列,使数列A满足所有的A[i] * A[i + 1](1 ≤ i ≤ N - 1)都是4的倍数。
小易现在需要判断一个数列是否可以重排之后满足牛博士的要求。

输入描述:
输入的第一行为数列的个数t(1 ≤ t ≤ 10),
接下来每两行描述一个数列A,第一行为数列长度n(1 ≤ n ≤ 10^5)
第二行为n个正整数A[i](1 ≤ A[i] ≤ 10^9)

输出描述:
对于每个数列输出一行表示是否可以满足牛博士要求,如果可以输出Yes,否则输出No。

输入例子1:
2
3
1 10 100
4
1 2 3 4

输出例子1:
Yes
No
 */
/*
显然，任意数和 4 的倍数相乘，其结果仍是 4 的倍数；
显然，若存在任意数量 2 的倍数，两两之间乘起来就是 4 的倍数；
如果存在一个数不是 2 的倍数，即它是一个奇数：
    放在 2 的倍数旁边，一定不符合要求；
    放在 4 的倍数旁边，相乘结果仍是 4 的倍数。

符合要求的排列分两种情况：
存在 2 的倍数，所有 2 的倍数相邻排列，需要一个 4 的倍数连接剩下的数，奇数最多和 4 的倍数数量相等，要求 mod4_num >= odd
没有 2 的倍数，原本放 2 的倍数一端可以改放一个奇数，mod4_num >= odd - 1
 */
public class Question05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for(int i = 0; i < num;i++){
            int n = sc.nextInt();
            int[] a = new int[n];
            for(int j = 0; j < n;j++){
                a[j] = sc.nextInt();
            }
            int mod4_num = 0;  //4的倍数的个数
            int mod2_num = 0;  //2的倍数的个数
            int odd = 0;       //奇数的个数
            for(int k = 0; k < a.length;k++){
                if(a[k]%4==0){
                    mod4_num++;
                }else if (a[k]%2==0){
                    mod2_num++;
                }else {
                    odd++;
                }
            }
            if(mod2_num>0){
                if(mod4_num>=odd){
                    System.out.println("Yes");
                }else {
                    System.out.println("No");
                }
            }else {
                if(mod4_num >=(odd-1)){
                    System.out.println("Yes");
                }else{
                    System.out.println("No");
                }
            }
        }
    }
}
