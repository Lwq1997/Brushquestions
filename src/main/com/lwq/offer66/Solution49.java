package main.com.lwq.offer66;

/**
 * @Author: Lwq
 * @Date: 2018/10/18 19:52
 * @Version 1.0
 * @Describe
 */

/**
 * 将一个字符串转换成一个整数(实现Integer.valueOf(string)
 * 的功能，但是string不符合数字要求时返回0)，
 * 要求不能使用字符串转换整数的库函数。
 * 数值为0或者字符串不是一个合法的数值则返回0。
 */
public class Solution49 {
    public int StrToInt(String str) {
        if(str.equals("")||str.length()==0){
            return 0;
        }
        char[] chars = str.toCharArray();
        int fuHao = 0;
        if(chars[0]=='-'){
            fuHao = 1;
        }
        int sum = 0;
        for(int i = fuHao;i<chars.length;i++){
            if(chars[i]=='+'){
                continue;
            }
            if(chars[i]<48||chars[i]>57){
                return 0;
            }
            sum = sum*10+chars[i]-48;
        }
        return fuHao==0?sum:sum*-1;
    }
}
