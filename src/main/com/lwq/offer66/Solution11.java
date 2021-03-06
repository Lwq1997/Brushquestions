package main.com.lwq.offer66;

/**
 * @Author: Lwq
 * @Date: 2018/10/11 20:52
 * @Version 1.0
 * @Describe
 */
/*
输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class Solution11 {
    public int NumberOf1(int n) {
        int count = 0;
        while (n!=0){
            count++;
            n = n&(n-1);
        }
        return count;
    }
}
