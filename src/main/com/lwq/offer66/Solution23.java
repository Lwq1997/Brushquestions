package main.com.lwq.offer66;

/**
 * @Author: Lwq
 * @Date: 2018/10/13 12:33
 * @Version 1.0
 * @Describe
 */
/*
输入一个整数数组，
判断该数组是不是某二叉搜索树的后序遍历的结果。
如果是则输出Yes,否则输出No。
假设输入的数组的任意两个数字都互不相同。
 */
public class Solution23 {
    public boolean VerifySquenceOfBST(int [] sequence) {
        int length = sequence.length;
        if(length==0){
            return false;
        }
        if(length==1){
            return true;
        }
        return isLastOrder(sequence,0,length-1);
    }

    private boolean isLastOrder(int[] sequence, int star, int root) {
        if(star>=root){
            return true;
        }
        int i = root;
        //从root开始往前看，找到一个比root小的数，位置为i-1
        while (i>star&&sequence[i-1]>sequence[root]){
            i--;
        }
        //从i的前面开始看，是不是每个数都小于root
        for(int j = star;j<i-1;j++){
            if(sequence[j]>sequence[root]){
                return false;
            }
        }
        //分别判断左右两个数
        return isLastOrder(sequence,star,i-1)&&isLastOrder(sequence,i,root-1);
    }
}
