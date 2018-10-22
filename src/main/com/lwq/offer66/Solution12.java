package main.com.lwq.offer66;

/**
 * @Author: Lwq
 * @Date: 2018/10/11 20:59
 * @Version 1.0
 * @Describe
 */
/*
给定一个double类型的浮点数base和int类型的整数exponent。
求base的exponent次方。
10^1101 = 10^0001*10^0100*10^1000。
 */
public class Solution12 {
    public double Power(double base, int n) {
        double res = 1,curr = base;
        int exponent;
        if(n>0){
            exponent = n;
        }else if(n<0){
            if(base==0)
                throw new RuntimeException("分母不能为0");
            exponent = -n;
        }else{// n==0
            return 1;// 0的0次方
        }
        while(exponent!=0){
            if((exponent&1)==1)
                res*=curr;
            curr*=curr;// 翻倍
            exponent>>=1;// 右移一位
        }
        return n>=0?res:(1/res);
    }
}
