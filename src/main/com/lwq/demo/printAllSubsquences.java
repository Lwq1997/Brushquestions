package main.com.lwq.demo;

/**
 * @Author: Lwq
 * @Date: 2018/9/21 13:30
 * @Version 1.0
 * @Describe
 */
/*
打印一个字符串的所有子序列
 */
public class printAllSubsquences {
    public static void main(String[] args) {
        String test = "ab";
        printAllSubsquence(test);
    }

    private static void printAllSubsquence(String str) {
        char[] chs = str.toCharArray();
        process(chs, 0,"");
    }

    private static void process(char[] chs, int i,String res) {
        if(i==chs.length){
            System.out.println(res);
            return;
        }
        process(chs,i+1,res+" ");
        process(chs,i+1,res+String.valueOf(chs[i]));
    }
}
