package main.com.lwq.wangyi;

import java.util.Scanner;

/**
 * @Author: Lwq
 * @Date: 2018/9/9 19:22
 * @Version 1.0
 * @Describe
 */
/*
在幼儿园有n个小朋友排列为一个队伍，从左到右一个挨着一个编号为
(0~n-1)。其中有一些是男生，有一些是女生，男生用'B'表示，
女生用'G'表示。小朋友们都很顽皮，当一个男生挨着的是女生的时候就会发生矛盾。
作为幼儿园的老师，你需要让男生挨着女生或者女生挨着男生的情况最少。
你只能在原队形上进行调整，每次调整只能让相邻的两个小朋友交换位置，
现在需要尽快完成队伍调整，
你需要计算出最少需要调整多少次可以让上述情况最少。例如：
GGBBG -> GGBGB -> GGGBB
这样就使之前的两处男女相邻变为一处相邻，需要调整队形2次

输入描述:
输入数据包括一个长度为n且只包含G和B的字符串.n不超过50.

输出描述:
输出一个整数，表示最少需要的调整队伍的次数

输入例子1:
GGBBG

输出例子1:
2
 */
/*
最终目标是将男孩移到最左边，或者将女孩移到最左边。
如果有B个男孩，则移到最左边的index分别为：0,1,2...B-1,
所以所有index的和为（B-1）*B/2
一次遍历，计算目前男孩所在的index的和为sumB，
则sumB减去上面的和就是所求的结果。
因此只要一次遍历，计算男孩所在的男孩的个数和男孩所在的index的和，
求之差就行了。女孩同理。最后求最小值。
 */
public class Question27 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int indexB = 0;
        int sumB = 0;
        int indexG = 0;
        int sumG = 0;
        for(int i = 0;  i < str.length() ;i++){
            if(str.charAt(i)=='B'){
                sumB+=i;
                indexB++;
            }else {
                sumG+=i;
                indexG++;
            }
        }
        System.out.println(Math.min(Math.abs(sumB-(indexB*(indexB-1))/2),Math.abs(sumG-(indexG*(indexG-1))/2)));
    }
}
