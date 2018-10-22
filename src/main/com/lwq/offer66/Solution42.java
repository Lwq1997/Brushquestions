package main.com.lwq.offer66;

/**
 * @Author: Lwq
 * @Date: 2018/10/17 21:43
 * @Version 1.0
 * @Describe
 */

import java.util.ArrayList;

/**
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，
 * 使得他们的和正好是S，如果有多对数字的和等于S，
 * 输出两个数的乘积最小的。两个距离越远，乘机越小
 */
public class Solution42 {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> res = new ArrayList<>();

        int left = 0;
        int right = array.length-1;
        while (left<right){
            if(array[left]+array[right]==sum){
                res.add(array[left]);
                res.add(array[right]);
                break;
            }
            while (array[left]+array[right]>sum){
                right--;
            }
            while (array[left]+array[right]<sum){
                left++;
            }
        }
        return res;
    }
}
