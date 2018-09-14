package main.com.lwq.demo;

/**
 * @Author: Lwq
 * @Date: 2018/9/14 22:00
 * @Version 1.0
 * @Describe
 */
/*
顺时针打印二维数组
 */
public class Demo34 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3},{8,9,4},{7,6,5}};
        spiralOrderPrint(matrix);
    }

    private static void spiralOrderPrint(int[][] matrix) {
        int tR = 0;                       //左上角的行数
        int tC = 0;                       //左上角的列数
        int dR = matrix.length-1;         //右下角的行数
        int dC = matrix[0].length-1;      //右下角的列数
        while (tR<=dR && tC<=dC){
            printEdge(matrix,tR++,tC++,dR--,dC--);
        }
    }

    private static void printEdge(int[][] matrix, int tR, int tC, int dR, int dC) {
        if(tR==dR){
            //左上角和右下角的行数相同，说明就是一行数据
            for(int i = tC;i<=dC;i++){
                System.out.println(matrix[tR][i]+" ");
            }
        }else if(tC==dC){
            //左下角和右下角的列数相同，说明就是一列数据
            for(int i = tR;i<=dR;i++){
                System.out.println(matrix[i][tC]+" ");
            }
        }else {
            //记录左上角的点的行数和列数
            int curC = tC;  //当前列
            int curR = tR;  //当前行
            while (curC!=dC){
                System.out.print(matrix[tR][curC]+" ");
                curC++;
            }
            while (curR!=dR){
                System.out.print(matrix[curR][dC]+" ");
                curR++;
            }
            while (curC!=tC){
                System.out.print(matrix[dR][curC]+" ");
                curC--;
            }
            while (curR!=tR){
                System.out.print(matrix[curR][tC]+" ");
                curR--;
            }
        }
    }
}
