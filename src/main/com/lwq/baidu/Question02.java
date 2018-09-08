package main.com.lwq.baidu;

import java.util.Scanner;

/**
 * @Author: Lwq
 * @Date: 2018/9/7 20:02
 * @Version 1.0
 * @Describe
 */
/*
一个数轴上共有N个点，第一个点的坐标是度度熊现在位置，第N个点是度度熊的家。现在他需要依次的从0号坐标走到N-1号坐标。
但是除了0号坐标和N号坐标，他可以在其余的N-2个坐标中选出一个点，并直接将这个点忽略掉，问度度熊回家至少走多少距离？

输入描述:
输入一个正整数N, N <= 50。
接下来N个整数表示坐标，正数表示X轴的正方向，负数表示X轴的负方向。绝对值小于等于100

输出描述:
输出一个整数表示度度熊最少需要走的距离。

输入例子1:
4
1 4 -1 3

输出例子1:
4
 */
/*
从N-2个坐标中选出一个点，并直接将这个点忽略掉。
直接忽略一个点只会直接影响到，这个节点前后节点的距离。
这个 影响的距离我们暂且命名为优化距离，将所有节点按顺序组成三个节点的集合，
通过这种方式只需要通过一次循环便能得到结果。
 */public class Question02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int length = sc.nextInt();
            int[] arr = new int[length];
            for(int i = 0; i < length;i++){
                arr[i] = sc.nextInt();
            }
            int sum = 0;
            for(int i = 0;i<length-1;i++){
                sum += Math.abs(arr[i+1]-arr[i]);
            }
            int distance = 0;
            for(int i = 1; i < length-1;i++){
                int del = Math.abs(arr[i+1]-arr[i])+Math.abs(arr[i]-arr[i-1])-Math.abs(arr[i+1]-arr[i-1]);
                if(del>distance){
                    distance=del;
                }
            }
            System.out.println(sum-distance);
        }
    }
}

