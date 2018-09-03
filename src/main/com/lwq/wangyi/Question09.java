package main.com.lwq.wangyi;

import java.util.Scanner;

/**
 * @Author: Lwq
 * @Date: 2018/9/3 15:38
 * @Version 1.0
 * @Describe
 */
/*
如果一个数字序列逆置之后跟原序列是一样的就称这样的数字序列为回文序列。例如：
{1, 2, 1}, {15, 78, 78, 15} , {112} 是回文序列,
{1, 2, 2}, {15, 78, 87, 51} ,{112, 2, 11} 不是回文序列。
现在给出一个数字序列，允许使用一种转换操作：
选择任意两个相邻的数，然后从序列移除这两个数，并用这两个数字的和插入到这两个数之前的位置(只插入一个和)。
现在对于所给序列要求出最少需要多少次操作可以将其变成回文序列。

输入描述:
输入为两行，第一行为序列长度n ( 1 ≤ n ≤ 50) 第二行为序列中的n个整数item[i] (1 ≤ iteam[i] ≤ 1000)，以空格分隔。

输出描述:
输出一个数，表示最少需要的转换次数

输入例子1:
4 1 1 1 3

输出例子1:
2
 */
/*
判断队首和队尾元素。若二者相等，则将这两个元素都弹出队列，将队列规模缩小2个，再对该问题进行判断；
若二者不相等，则选择其中较小的一个，将该元素和与其相邻的元素都弹出队列，再将其和插入队列，从而将队列规模缩小1个，再对该问题进行判断。
 */
public class Question09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int times = 0;
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i  =0; i <n;i++){
                arr[i] = sc.nextInt();
            }
            int head = 0,tail = n-1;
            while (head<tail){
                if(arr[head]<arr[tail]){
                    int add = arr[head]+arr[head+1];
                    arr[++head] = add;
                    times++;
                }else if(arr[head]>arr[tail]){
                    int add = arr[tail]+arr[tail-1];
                    arr[--tail] = add;
                    times++;
                }else {
                    head++;
                    tail--;
                }
            }
            System.out.println(times);
        }
    }
}
