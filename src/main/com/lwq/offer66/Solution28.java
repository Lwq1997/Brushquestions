package main.com.lwq.offer66;

/**
 * @Author: Lwq
 * @Date: 2018/10/16 15:30
 * @Version 1.0
 * @Describe
 */

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。
 * 如果不存在则输出0。
 */
public class Solution28 {
    public static void main(String[] args) {
        System.out.println(MoreThanHalfNum_Solution(new int[]{4,2,1,4,2,4}));
    }
    public static int MoreThanHalfNum_Solution(int [] array) {
        int count = 1;
        int data = array[0];
        for(int i = 0; i < array.length; i++){
            if(count==0){
                data = array[i];
                count = 1;
            }else if(data==array[i]){
                count++;
            }else {
                count--;
            }
        }
        int time = 0;
        for(int i = 0; i<array.length;i++){
            if(array[i]==data){
                time++;
            }
        }
        if(time*2<=array.length){
            System.out.println(time);
            return 0;
        }else {
            return data;
        }
    }
}
