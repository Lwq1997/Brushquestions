package main.com.lwq.offer66;

import java.util.ArrayList;

/**
 * @Author: Lwq
 * @Date: 2018/10/13 11:18
 * @Version 1.0
 * @Describe
 */
/*
输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class Solution19 {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        int tR = 0;   //左上角的行数
        int tC = 0;   //左上角的列数
        int dR = matrix.length-1 ;   //右下角的行数
        int dC = matrix[0].length-1 ;  //右下角的列数
        ArrayList<Integer> list = new ArrayList<>();
        while (tR<=dR && tC<=dC){
            printEdge(matrix,tR++,tC++,dR--,dC--,list);
        }
        return list;
    }

    private void printEdge(int[][] matrix, int tR, int tC, int dR, int dC,ArrayList list) {
        if(tR==dR){
            //左上角和右下角的行数相同说明是一行数据
            for(int i = tC;i<=dC;i++){
                list.add(matrix[tR][i]);
            }
        }else if(tC==dC){
            //说明是一列数据
            for(int i = tR;i<=dR;i++){
                list.add(matrix[i][tC]);
            }
        }else {
            int curR = tR;
            int curC = tC;
            while (curC!=dC){
                list.add(matrix[tR][curC]);
                curC++;
            }
            while (curR!=dR){
                list.add(matrix[curR][dC]);
                curR++;
            }
            while (curC!=tC){
                list.add(matrix[dR][curC]);
                curC--;
            }
            while (curR!=tR){
                list.add(matrix[curR][tC]);
                curR--;
            }
        }
    }
}
