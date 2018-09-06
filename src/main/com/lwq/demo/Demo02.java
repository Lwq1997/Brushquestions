package main.com.lwq.demo;

/**
 * @Author: Lwq
 * @Date: 2018/9/6 10:56
 * @Version 1.0
 * @Describe 大数相乘
 */
/*
        9  8
×       2  1
-------------
       (9)(8)  <---- 第1趟: 98×1的每一位结果
  (18)(16)     <---- 第2趟: 98×2的每一位结果
-------------
  (18)(25)(8)  <---- 这里就是相对位的和，还没有累加进位
 */
public class Demo02 {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1,2};
        int[] arr2 = new int[]{1,2};
        int[] sum = bigNumberMultiplt(arr1,arr2);
    }

    private static int[] bigNumberMultiplt(int[] num1, int[] num2) {
        int[] result  = new int[num1.length+num2.length];
        for(int i = 0; i < num1.length;i++){
            for(int j = 0;j<num2.length;j++){
                result[i+j+1] += num1[i]*num1[j];
            }
        }
        for(int k = result.length-1;k>0;k--){
            if(result[k]>10){
                result[k-1] += result[k]/10;
                result[k] %= 10;
            }
        }
        return result;
    }
}
