package main.com.lwq.demo;

import java.util.Scanner;

/**
 * @Author: Lwq
 * @Date: 2018/9/18 15:36
 * @Version 1.0
 * @Describe
 */
/*
已知局域网 ip 段为
10.0.0.0～10.255.255.255，
172.16.0.0～172.31.255.255，
192.168.0.0～192.168.255.255，
给定一个ip地址，判断是否是属于局域网 ip。

转换为十进制
 */
public class Demo46 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        if(isInnerIp(str)){
            System.out.println("True");
        }else{
            System.out.println("False");
        }
    }

    private static boolean isInnerIp(String str) {
        boolean flag = false;
        long ipNum = getNum(str);

        long aBegin = getNum("10.0.0.0");
        long aEnd = getNum("10.255.255.255");
        long bBegin = getNum("172.16.0.0");
        long bEnd = getNum("172.31.255.255");
        long cBegin = getNum("192.168.0.0");
        long cEnd = getNum("192.168.255.255");

        flag = isInner(ipNum,aBegin,aEnd) || isInner(ipNum,bBegin,bEnd) || isInner(ipNum,cBegin,cEnd) || str.equals("127.0.0.1");

        return flag;
    }

    private static boolean isInner(long ipNum, long begin, long end) {
        return (ipNum>=begin) && (ipNum<=end);
    }

    private static long getNum(String str) {
        String[] strs = str.split("\\.");
        int a = Integer.parseInt(strs[0]);
        int b = Integer.parseInt(strs[1]);
        int c = Integer.parseInt(strs[2]);
        int d = Integer.parseInt(strs[3]);

        return  a * 256 * 256 * 256 + b * 256 * 256 + c * 256 + d;
    }
}
