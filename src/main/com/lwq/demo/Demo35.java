package main.com.lwq.demo;

/**
 * @Author: Lwq
 * @Date: 2018/9/14 22:23
 * @Version 1.0
 * @Describe
 */
/*
原地转数组
 */
public class Demo35 {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        for(int i = 0 ; i < arr.length;i++){
            for(int j = 0;j < arr[0].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("********************");
        rotate(arr);
        for(int i = 0 ; i < arr.length;i++){
            for(int j = 0;j < arr[0].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static void rotate(int[][] arr) {
        int tR = 0;
        int tC = 0;
        int dR = arr.length-1;
        int dC = arr[0].length-1;
        while (tR < dR) {
            rotateEdge(arr, tR++, tC++, dR--, dC--);
        }
    }

    private static void rotateEdge(int[][] m, int tR, int tC, int dR, int dC) {
        int times = dC-tC;
        int tmp = 0;
        for(int i = 0; i != times;i++){
            //i相当于偏移量
            tmp = m[tR][tC + i];
            m[tR][tC + i] = m[dR - i][tC];
            m[dR - i][tC] = m[dR][dC - i];
            m[dR][dC-i] = m[tR+i][dC];
            m[tR + i][dC] = tmp;
        }
    }
}
