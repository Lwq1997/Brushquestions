package main.com.lwq.offer66;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @Author: Lwq
 * @Date: 2018/10/14 12:26
 * @Version 1.0
 * @Describe
 */
/*
输入一个字符串,按字典序打印出该字符串中字符的所有排列。
例如输入字符串abc,
则打印出由字符a,b,c
所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 */
public class Solution27 {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if(str!=null&&str.length()>0){
            PermutationHelper(str.toCharArray(),0,res);
            Collections.sort(res);
        }
        return res;
    }

    private void PermutationHelper(char[] chars, int i, ArrayList<String> res) {
        if(i==chars.length-1){
            String val = String.valueOf(chars);
            if(!res.contains(val)){
                res.add(val);
            }
        }else {
            for(int j = i; j < chars.length;j++){
                swap(chars,i,j);
                PermutationHelper(chars,i+1,res);
                swap(chars,i,j);
            }
        }
    }
    public void swap(char[] cs, int i, int j) {
        char temp = cs[i];
        cs[i] = cs[j];
        cs[j] = temp;
    }
}
