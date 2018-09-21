package main.com.lwq.demo;

/**
 * @Author: Lwq
 * @Date: 2018/9/21 16:49
 * @Version 1.0
 * @Describe
 */
/*
从一个二维数组的左上角走到右下角，经过的最短路径（经过的数组累加）
 */
public class MinPath {
    public static void main(String[] args) {
        int[][] m = { { 1, 3, 5, 9 }, { 8, 1, 3, 4 }, { 5, 0, 6, 1 }, { 8, 8, 4, 0 } };
        System.out.println(minPath1(m));
        System.out.println(minPath2(m));

//        m = generateRandomMatrix(6, 7);
//        System.out.println(minPath1(m));
//        System.out.println(minPath2(m));
    }

    //理解为从右下角到左上角
    private static int minPath2(int[][] m) {
        if(m == null || m.length == 0 || m[0] == null || m[0].length == 0){
            return 0;
        }
        int row = m.length;
        int col = m[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = m[0][0];
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i - 1][0] + m[i][0];
        }
        for (int j = 1; j < col; j++) {
            dp[0][j] = dp[0][j - 1] + m[0][j];
        }
        for(int i = 1; i < row; i++){
            for(int j = 1;j < col;j++){
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+m[i][j];
            }
        }
        return dp[row-1][col-1];
    }

    private static int minPath1(int[][] m) {
        return walk(m,0,0);
    }

    private static int walk(int[][] m, int i, int j) {
        //就在最后的位置上
        if(i == m.length-1 && j == m[0].length-1){
            return m[i][j];
        }
        //在最后一行
        if (i == m.length-1){
            return m[i][j]+walk(m,i,j+1);
        }
        //在最后一列
        if(j == m[0].length -1){
            return m[i][j]+walk(m,i+1,j);
        }
        //在中间
        int right = walk(m,i,j+1);
        int down = walk(m,i+1,j);
        return m[i][j]+Math.min(right,down);
    }
}
