package main.com.lwq.demo;

/**
 * @Author: Lwq
 * @Date: 2018/9/21 11:00
 * @Version 1.0
 * @Describe
 */
public class Islands {
    public static void main(String[] args) {
        int[][] m1 = {  { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 1, 1, 1, 0, 1, 1, 1, 0 },
                { 0, 1, 1, 1, 0, 0, 0, 1, 0 },
                { 0, 1, 1, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 1, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, };
        System.out.println(countIslands(m1));

        int[][] m2 = {  { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 1, 1, 1, 1, 1, 1, 1, 0 },
                { 0, 1, 1, 1, 0, 0, 0, 1, 0 },
                { 0, 1, 1, 0, 0, 0, 1, 1, 0 },
                { 0, 0, 0, 0, 0, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 1, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, };
        System.out.println(countIslands(m2));

    }

    private static int countIslands(int[][] m) {
        int res = 0;
        int M = m.length;
        int N = m[0].length;
        for(int i = 0; i < M;i++){
            for(int j = 0; j < N;j++){
                if(m[i][j]==1){
                    infect(m,i,j,M,N);
                    res++;
                }
            }
        }
        return res;
    }

    private static void infect(int[][] m, int i, int j, int M, int N) {
        if (i < 0 || i >= N || j < 0 || j >= M || m[i][j] != 1) {
            return;
        }
        m[i][j] = 2;
        infect(m, i + 1, j, M, N);
        infect(m, i - 1, j, M, N);
        infect(m, i, j + 1, M, N);
        infect(m, i, j - 1, M, N);
    }
}
