package main.com.lwq.offer66;

/**
 * @Author: Lwq
 * @Date: 2018/10/11 14:37
 * @Version 1.0
 * @Describe
 */
/*
在一个二维数组中（每个一维数组的长度相同），
每一行都按照从左到右递增的顺序排序，
每一列都按照从上到下递增的顺序排序。请完成一个函数，
输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class Solution01 {
    public static void main(String[] args) {
        int target = 15;
        int[][] array = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        System.out.println(Find(target,array));
    }
    public static boolean Find(int target, int [][] array) {
        int x = array.length-1;
        int y = 0;
        while (x>-1&&y<array[0].length){
            if(array[x][y]==target){
                return true;
            }else if(array[x][y]>target){
                x--;
            }else {
                y++;
            }
        }
        return false;
    }
}

