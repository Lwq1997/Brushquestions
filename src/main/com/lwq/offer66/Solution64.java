package main.com.lwq.offer66;

/**
 * @Author: Lwq
 * @Date: 2018/10/19 21:42
 * @Version 1.0
 * @Describe
 */

import java.util.ArrayList;

/**
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
 * 那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}，
 * {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}，
 * {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 */
public class Solution64 {
    public static void main(String[] args) {
        maxInWindows(new int[]{2,3,4,2,6,2,5,1},3);
    }
    public static ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> ret = new ArrayList<>();
        if(size>num.length||size==0){
            return ret;
        }
        for(int i = 0; i <= num.length-size ; i++){
            int max = num[i];
            for(int j = i+1 ; j < i+size; j++){
                if(num[j]>max){
                    max = num[j];
                }
            }
            ret.add(max);
        }
        return ret;
    }
}