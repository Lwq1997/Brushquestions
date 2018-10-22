package main.com.lwq.offer66;

/**
 * @Author: Lwq
 * @Date: 2018/10/11 21:16
 * @Version 1.0
 * @Describe
 */
/*
输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class Solution13 {
    public void reOrderArray(int [] array) {
        for(int i = 0; i < array.length;i++){
            for(int j = array.length-1;j>i;j--){
                //前偶后奇就交换
                if(array[j]%2==1&&array[j-1]%2==0){
                    swap(array,j,j-1);
                }
            }
        }
    }

    private void swap(int[] array, int j, int i) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
