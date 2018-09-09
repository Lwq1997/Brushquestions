package main.com.lwq.huawei;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: Lwq
 * @Date: 2018/9/8 20:08
 * @Version 1.0
 * @Describe
 */
/*
数独是一个我们都非常熟悉的经典游戏，运用计算机我们可以很快地解开数独难题，现在有一些简单的数独题目，请编写一个程序求解。

输入描述:
输入9行，每行为空格隔开的9个数字，为0的地方就是需要填充的。

输出描述:
输出九行，每行九个空格隔开的数字，为解出的答案。
 */
public class Question09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int[][] data = new int[9][9];
            List<HashSet<Integer>> row = new ArrayList<>();
            List<HashSet<Integer>> col = new ArrayList<>();
            List<HashSet<Integer>> squ = new ArrayList<>();

            for(int i = 0; i < 9;i++){
                row.add(new HashSet<>());
                col.add(new HashSet<>());
                squ.add(new HashSet<>());
            }

            for(int i = 0; i < 9;i++){
                for(int j = 0; j < 9;j++){
                    if(data[i][j]==0){
                        row.get(i).add(data[i][j]);
                        col.get(i).add(data[i][j]);
                        squ.get(i/3*3+j/3).add(data[i][j]);
                    }
                }
            }

            dfs(data,row,col,squ,0);

            for(int i = 0; i < 9;i++){
                for(int j = 0; j < 9;j++){
                    if(j!=8){
                        System.out.println(data[i][j]+" ");
                    }else {
                        System.out.println(data[i][j]);
                    }
                }
            }
        }
    }

    private static boolean dfs(int[][] data, List<HashSet<Integer>> row, List<HashSet<Integer>> col, List<HashSet<Integer>> squ, int index) {
        if(index==81){
            return true;
        }
        int m = index/9;
        int n = index%9;
        int k=m/3*3+n/3;

        if(data[m][n]!=0){
            return dfs(data,row,col,squ,index+1);
        }else {
            for(int i = 1; i <= 9;i++){
                if(!row.get(m).contains(i)&&!col.get(n).contains(i)&&!squ.get(k).contains(i)){
                    data[m][n] = i;
                    row.get(m).add(i);
                    col.get(n).add(i);
                    squ.get(k).add(i);

                    if(dfs(data,row,col,squ,index+1)){
                        return true;
                    }

                    data[m][n] = 0;
                    row.get(m).remove(i);
                    col.get(n).remove(i);
                    squ.get(k).remove(i);
                }
            }
            return false;
        }
    }
}
