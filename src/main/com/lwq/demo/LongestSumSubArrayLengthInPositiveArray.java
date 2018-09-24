package main.com.lwq.demo;

/**
 * @Author: Lwq
 * @Date: 2018/9/24 17:55
 * @Version 1.0
 * @Describe
 */
/*
一个数组(全是正整数)和一个数，返回数组中最长连续子数组的和等于这个数。返回最长子数组的长度
 */
public class LongestSumSubArrayLengthInPositiveArray {
    public static void main(String[] args) {
        System.out.println(getMaxLength(new int[]{2,5,4,8,9,5,1,1,1,1},9));
    }

    public static int getMaxLength(int[] arr,int k){
        if(arr==null||arr.length==0||k<=0){
            return 0;
        }
        int L = 0;
        int R = 0;
        int sum = arr[0];
        int len = 0;
        while (R<arr.length){
            if(sum == k){
                len = Math.max(len,R-L+1);
                sum -= arr[L++];
            }else if(sum < k){
                R++;
                if(R==arr.length){
                    break;
                }
                sum += arr[R];
            }else {  //sum>k
                sum -= arr[L++];
            }
        }
        return len;
    }
}
