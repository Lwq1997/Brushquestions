package main.com.lwq.offer66;

/**
 * @Author: Lwq
 * @Date: 2018/10/11 16:14
 * @Version 1.0
 * @Describe
 */
/*
一只青蛙一次可以跳上1级台阶，也可以跳上2级。
求该青蛙跳上一个n级的台阶总共有多少种跳法
（先后次序不同算不同的结果）
 */
public class Solution08 {
    public int JumpFloor(int target) {
        if(target<=0){
            return 0;
        }
        if(target==1){
            return 1;
        }
        int fib1 = 0;
        int fib2 = 1;
        int fib3 = 1;
        for(int i = 2; i <= target ;i++){
            fib1 = fib2+fib3;
            fib2 = fib3;
            fib3 = fib1;
        }
        return fib1;
    }
}
