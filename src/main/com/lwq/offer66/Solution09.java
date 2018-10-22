package main.com.lwq.offer66;

/**
 * @Author: Lwq
 * @Date: 2018/10/11 16:14
 * @Version 1.0
 * @Describe
 */
/*
一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class Solution09 {
    public int JumpFloorII(int target) {
        if(target<=0){
            return 0;
        }
        if(target==1){
            return 1;
        }
        int sum = 1;
        for(int i = 2; i <= target;i++){
            sum = sum*2;
        }
        return sum;
    }
}
