package main.com.lwq.wangyi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: Lwq
 * @Date: 2018/9/9 19:22
 * @Version 1.0
 * @Describe
 */
/*
小易有一个长度为n序列，小易想移除掉里面的重复元素，
但是小易想是对于每种元素保留最后出现的那个。小易遇到了困难,
希望你来帮助他。

输入描述:
输入包括两行： 第一行为序列长度n(1 ≤ n ≤ 50) 第二行为n个数sequence[i](1 ≤ sequence[i] ≤ 1000)，以空格分隔

输出描述:
输出消除重复元素之后的序列，以空格分隔，行末无空格

输入例子1:
9 100 100 100 99 99 99 100 100 100

输出例子1:
99 100
 */
/*
此题巧妙地用到了List去重的方法。
比如说有一组数，为1 5 5 1 6 1
从[0,n-1]使用List去重之后，保存地其实就是每种元素最开始出现的那个元素。
但是我们换个角度去想，如果我们从后向前遍历，保存地就是每种元素最后出现的那个元素，只不过相对从前到后来说，数倒过来了。
我们最终将数反转过来即可。
时间复杂度为O(n)
 */
public class Question28 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int[] arr = new int[n];
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < n;i++){
                arr[i] = sc.nextInt();
            }
            for(int i = n-1;i>-1;i--){
                if(!list.contains(arr[i])){
                    list.add(arr[i]);
                }
            }
            for(int i = list.size()-1;i>-1;i--){
                System.out.print(list.get(i));
                if(i!=0){
                    System.out.print(" ");
                }
            }
        }
    }
}
