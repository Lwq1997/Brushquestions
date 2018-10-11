package main.com.lwq.demo;

import java.util.HashMap;

/**
 * @Author: Lwq
 * @Date: 2018/9/24 17:55
 * @Version 1.0
 * @Describe
 */
/*
给定一个数组arr，值可正，可负，可0，一个整数aim，求累加和小于等于aim的最长子数组
 */
public class LongestSubArrayLessSumAweSolution {
    public static void main(String[] args) {
        System.out.println(maxLengthAwesome(new int[]{2,5,4,8,9,5,1,1,1,1},9));
        System.out.println(FindGreatestSumOfSubArray(new int[]{-3,-1,-8,-4,9}));
        System.out.println(FindGreatestSumOfSubArray1(new int[]{-3,-1,-8,-4,9}));
    }

    public static int FindGreatestSumOfSubArray(int[] array) {
        if(array.length==0)
            return 0;
        else{
            int total=array[0],maxSum=array[0];
            for(int i=1;i<array.length;i++){
                if(total>=0)
                    total+=array[i];
                else
                    total=array[i];
                if(total>maxSum)
                    maxSum=total;
            }
            return maxSum;
        }

    }

    public static int FindGreatestSumOfSubArray1(int[] array) {
        int count = Integer.MIN_VALUE;
        int p=0;
        for(int i=0; i < array.length; i++)
        {
            p=p+array[i];
            if(p > count) count=p;
            if(p <= 0) p=0;
        }
        return count;
    }

    public static int maxLengthAwesome (int[] arr,int k){
        if(arr==null||arr.length==0||k<=0){
            return 0;
        }
        int[] sums = new int[arr.length];
        HashMap<Integer,Integer> ends = new HashMap<>();
        sums[arr.length-1] = arr[arr.length-1];
        ends.put(arr.length-1,arr.length-1);
        for(int i = arr.length-2 ; i>-1;i--){
            if(sums[i+1]<0){
                sums[i] = arr[i]+sums[i+1];
                ends.put(i,ends.get(i+1));
            }else {
                sums[i] = arr[i];
                ends.put(i,i);
            }
        }
        int end = 0;
        int sum = 0;
        int res = 0;
        for(int start = 0; start < arr.length ; start++){
            while (end<arr.length && sum + sums[end]<=k){
                sum += sums[end];
                end = ends.get(end)+1;
            }
            sum -= end>start?arr[start]:0;
            res = Math.max(res,end-start);
            end = Math.max(end,start+1);
        }
        return res;
    }
}
