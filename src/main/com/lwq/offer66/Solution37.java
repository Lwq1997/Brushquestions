package main.com.lwq.offer66;

/**
 * @Author: Lwq
 * @Date: 2018/10/17 14:57
 * @Version 1.0
 * @Describe
 */

/**
 * 统计一个数字在排序数组中出现的次数。
 */
public class Solution37 {
    public static void main(String[] args) {
        System.out.println(GetNumberOfK02(new int[]{1,2,2,2,3},2));
    }
    public int GetNumberOfK(int [] array , int k) {
        int count = 0;
        for(int i = 0;i < array.length ; i++){
            if(array[i]==k){
                count++;
            }
        }
        return count;
    }
    public static int GetNumberOfK02(int [] array , int k) {
        return biSearch(array,k+0.5)-biSearch(array,k-0.5);
    }

    private static int biSearch(int[] array, double v) {
        int start = 0;
        int end = array.length-1;
        while (start<=end){
            int mid = start+(end-start)/2;
            if(array[mid]>v){
                end = mid-1;
            }else if(array[mid]<v) {
                start = mid+1;
            }
        }
        return start;
    }
}
