package main.com.lwq.huawei;

import java.util.Scanner;

/**
 * @Author: Lwq
 * @Date: 2018/8/31 10:11
 * @Version 1.0
 * @Describe
 */

/*
老师想知道从某某同学当中，分数最高的是多少，现在请你编程模拟老师的询问。当然，老师有时候需要更新某位同学的成绩.

详述：
输入包括多组测试数据。
每组输入第一行是两个正整数N和M（0 < N <= 30000,0 < M < 5000）,分别代表学生的数目和操作的数目。
学生ID编号从1编到N。
第二行包含N个整数，代表这N个学生的初始成绩，其中第i个数代表ID为i的学生的成绩
接下来又M行，每一行有一个字符C（只取‘Q’或‘U’），和两个正整数A,B,当C为'Q'的时候, 表示这是一条询问操作，他询问ID从A到B（包括A,B）的学生当中，成绩最高的是多少
当C为‘U’的时候，表示这是一条更新操作，要求把ID为A的学生的成绩更改为B。

输入例子1:
5 7
1 2 3 4 5
Q 1 5
U 3 6
Q 3 4
Q 4 5
U 4 5
U 2 9
Q 1 5

输出例子1:
5
6
5
9
 */
public class Test01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = 0;
        int N = 0;
        int i;
        int A = 0;
        int B = 0;
        while (sc.hasNext()){
            N = sc.nextInt();
            M = sc.nextInt();
//            System.out.println(N+" "+M);
            int[] score = new int[N];
            for(i = 0; sc.hasNext()&&i<N;i++){
                score[i] = sc.nextInt();
//                System.out.println("score["+i+"]"+" "+score[i]);
            }
            String c = null;
            for(i = 0;sc.hasNext()&&i<M;i++){
                c = sc.next();
                A = sc.nextInt();
                B = sc.nextInt();
                process(c,A,B,score);
            }
        }
    }

    private static void process(String c, int a, int b, int[] score) {
        int begin,end;
        if(c.equals("Q")){
            end = Math.max(a,b);
            begin = Math.min(a,b)-1;
            int max = score[begin];
            for(int i = begin;i<end;i++){
                if(max<score[i]){
                    max = score[i];
                }
            }
            System.out.println(max);
        }else if(c.equals("U")){
            score[a-1] = b;
        }
    }
}
