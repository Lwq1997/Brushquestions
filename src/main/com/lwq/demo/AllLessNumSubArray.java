package main.com.lwq.demo;

import java.util.LinkedList;

/**
 * @Author: Lwq
 * @Date: 2018/9/22 16:43
 * @Version 1.0
 * @Describe
 */
/*
给一个数组，求出有多少个子数组，子数组满足：子数组中的最大值和最小值的差小于num
 */
public class AllLessNumSubArray {
    public static void main(String[] args) {

    }

    public static int getNum(int[] arr,int num){
        if(arr==null||arr.length==0){
            return 0;
        }
        LinkedList<Integer> qmin = new LinkedList<>();
        LinkedList<Integer> qmax = new LinkedList<>();
        int start = 0;
        int end = 0;
        int res = 0;
        while (start<arr.length){
            while (end < arr.length) {
                while (!qmin.isEmpty()&&arr[qmin.peekLast()]>=arr[end]){
                    qmin.pollLast();
                }
                qmin.addLast(end);
                while (!qmax.isEmpty()&&arr[qmax.peekLast()]<=arr[end]){
                    qmax.pollLast();
                }
                qmax.addLast(end);
                if(arr[qmax.pollFirst()]-arr[qmin.pollFirst()]>num){
                    //不达标
                    break;
                }
                end++;
            }
            //看下表有没有过期
            if(qmin.peekFirst()==start){
                qmin.pollFirst();
            }
            if(qmax.peekFirst()==start){
                qmax.pollFirst();
            }
            res+=(end-start);
            start++;
        }
        return res;
    }

    public static int getNum1(int[] arr,int num){
        int res = 0;
        for(int start = 0; start < arr.length ; start++){
            for(int end = start; end < arr.length ; end++){
                if(isValid(arr,start,end,num)){
                    res++;
                }
            }
        }
        return res;
    }

    private static boolean isValid(int[] arr, int start, int end, int num) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = start ; i <= end; i++ ){
            min = Math.min(min,arr[i]);
            max = Math.max(max,arr[i]);
        }
        return max - min <= num;
    }
}
