package main.com.lwq.demo;

import java.util.Scanner;

/**
 * @Author: Lwq
 * @Date: 2018/9/11 0:07
 * @Version 1.0
 * @Describe
 */
/*
z型打印二维数组
或者斜线打印
 */
public class Demo12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int row = sc.nextInt();
            int col = sc.nextInt();
            int[][] arr = new int[row][col];
            for(int i = 0; i < row;i++){
                for(int j = 0; j < col;j++){
                    arr[i][j] = sc.nextInt();
                }
            }
            //z型打印数组
            printMatrixZigZag(arr);
        }
    }

    public static void printMatrixZigZag(int[][] matrix) {
        int tR = 0;
        int tC = 0;
        int dR = 0;
        int dC = 0;
        int endR = matrix.length - 1;
        int endC = matrix[0].length - 1;
        boolean fromUp = false;
        while (tR != endR + 1) {
            printLevel(matrix, tR, tC, dR, dC, fromUp);
            tR = tC == endC ? tR + 1 : tR;  //t点每次向右移动，移动到最后一列，然后在向下移动
            tC = tC == endC ? tC : tC + 1;
            dC = dR == endR ? dC + 1 : dC;  //d点每次向下移动，移动到最后一行，再向右移动
            dR = dR == endR ? dR : dR + 1;
            fromUp=!fromUp;//去掉这一行就是斜线打印
        }
        System.out.println();
    }

    public static void printLevel(int[][] m, int tR, int tC, int dR, int dC,
                                  boolean f) {
        if (f) {
            //往下
            while (tR != dR + 1) {
                System.out.print(m[tR++][tC--] + " ");
            }
        } else {
            //往上
            while (dR != tR - 1) {
                System.out.print(m[dR--][dC++] + " ");
            }
        }
    }
}
