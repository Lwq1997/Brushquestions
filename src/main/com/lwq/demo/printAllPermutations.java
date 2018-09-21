package main.com.lwq.demo;

/**
 * @Author: Lwq
 * @Date: 2018/9/21 13:34
 * @Version 1.0
 * @Describe
 */
public class printAllPermutations {
    public static void main(String[] args) {
        String test1 = "abc";
        printAllPermutations1(test1);
        System.out.println("======");
        printAllPermutations2(test1);
        System.out.println("======");

        String test2 = "acc";
        printAllPermutations1(test2);
        System.out.println("======");
        printAllPermutations2(test2);
        System.out.println("======");
    }

    private static void printAllPermutations2(String str) {

    }

    private static void printAllPermutations1(String str) {
        char[] chs = str.toCharArray();
        process1(chs, 0);
    }

    private static void process1(char[] chs, int i) {
        if(i == chs.length){
            System.out.println(String.valueOf(chs));
        }
        for(int j = i; j < chs.length ;j++){
            swap(chs,i,j);
            process1(chs,i+1);
        }
    }

    public static void swap(char[] chs, int i, int j) {
        char tmp = chs[i];
        chs[i] = chs[j];
        chs[j] = tmp;
    }
}
