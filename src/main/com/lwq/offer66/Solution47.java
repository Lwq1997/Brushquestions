package main.com.lwq.offer66;

/**
 * @Author: Lwq
 * @Date: 2018/10/18 19:21
 * @Version 1.0
 * @Describe
 */

/**
 * 求1+2+3+...+n，要求不能使用
 * 乘除法、for、while、if、else、switch、case
 * 等关键字及条件判断语句（A?B:C）。
 */
public class Solution47 {
    /**
     * 用&&的短路来判断n的大小
     * @param n
     * @return
     */
    public int Sum_Solution(int n) {
        int sum = n;
        boolean ans = (n>0)&&(sum+=Sum_Solution(n-1))>0;
        return sum;
    }
}
