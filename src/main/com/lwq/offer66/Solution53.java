package main.com.lwq.offer66;

/**
 * @Author: Lwq
 * @Date: 2018/10/19 11:05
 * @Version 1.0
 * @Describe
 */

/**
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"
 * 都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 */
public class Solution53 {
    public boolean isNumeric(char[] str) {
        boolean sign = false,decimal = false,haeE = false;
        for(int i = 0; i < str.length; i++){
            char c = str[i];
            if(c=='e'||c=='E'){
                if(i==str.length-1){
                    return false;   //e后面一定要有数字
                }
                if (haeE){
                    return false;   //不能同时存在两个e
                }
                haeE = true;
            }else if(c=='+'||c=='-'){
                if(sign&&str[i-1]!='e'&&str[i-1]!='E'){
                    //第二次出现+-号，必须在E之后
                    return false;
                }
                if(!sign&&i>0&&str[i-1]!='e'&&str[i-1]!='E'){
                    //第一次出现+-号，且不在字符串开头，则必须在E之后
                    return false;
                }
                sign = true;
            }else if(c=='.'){
                //小数点不能出现两次，且不能和e共存
                if(haeE||decimal){
                    return false;
                }
                decimal = true;
            }else if(c<'0'||c>'9'){
                return false;
            }
        }
        return true;
    }
}
