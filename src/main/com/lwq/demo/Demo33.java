package main.com.lwq.demo;

import java.util.Scanner;

/**
 * @Author: Lwq
 * @Date: 2018/9/14 19:27
 * @Version 1.0
 * @Describe
 */
/*
找出两个字符串中公共子串的长度
 */
public class Demo33 {
  public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        scanner.close();

        //字符串的长度
        int n1 = str1.length();
        int n2 = str2.length();

        //边界情况
        if(n1 < 1 || n2 < 1)
        {
            System.out.println(0);
            return;
        }
        //利用空间存储两个串的比较结果，空间换时间
        int temp[][] = new int[n1][n2];
        //表示最长的公共字串的变量
        int longest = 0;
        char[] char1 = str1.toCharArray();
        char[] char2 = str2.toCharArray();

        //初始化数组temp
        for(int i = 0; i < n1; i++)
        {
            for(int j = 0;j <n2;j++)
            {
                temp[i][j] = 0;
            }
        }

        //初始化第一行，初始化第一列，因为状态转移公式：item[i][j]=1 +item[i-1][j-1]
        for(int i = 0;i < n1;i++)
        {
            if(char1[i] == char2[0])
                temp[i][0] = 1;
        }

        for(int i = 0;i < n2;i++)
        {
            if(char1[0] == char2[i])
                temp[0][i] = 1;
        }


        //利用状态转移方程进行填充temp二维数组
        for(int i = 1; i < n1;i++)
        {
            for(int j = 1; j<n2;j++)
            {
                if (char1[i] == char2[j])
                {
                    temp[i][j] = temp[i-1][j-1] +1;
                }
            }
        }
        for(int i = 0; i < n1;i++)
        {
            for(int j = 0; j<n2;j++)
            {
                if(temp[i][j] > longest)
                    longest = temp[i][j];
            }
        }
        System.out.println(longest);
    }
}