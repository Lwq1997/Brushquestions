package main.com.lwq.offer66;

/**
 * @Author: Lwq
 * @Date: 2018/10/11 15:18
 * @Version 1.0
 * @Describe
 */
/*
请实现一个函数，将一个字符串中的每个空格替换成“%20”。
例如，当字符串为We Are Happy.
则经过替换之后的字符串为We%20Are%20Happy。
 */
public class Solution02 {
    public static void main(String[] args) {
        StringBuffer s = new StringBuffer("We Are Happy.");
        System.out.println(replaceSpace(s));
        System.out.println(replaceSpace01(s));
    }
    public static String replaceSpace(StringBuffer str) {
        return str.toString().replaceAll(" ","%20");
    }
    public static String replaceSpace01(StringBuffer str) {
        int spaceNum = 0;
        for(int i = 0; i < str.length();i++){
            if(str.charAt(i)==' '){
                spaceNum++;
            }
        }
        int indexOld = str.length()-1;
        int newLength = str.length()+spaceNum*2;
        int indexNew = newLength-1;
        str.setLength(newLength);
        for(;indexNew>-1&&indexOld<newLength;--indexOld){
            if(str.charAt(indexOld) == ' '){  //
                str.setCharAt(indexNew--, '0');
                str.setCharAt(indexNew--, '2');
                str.setCharAt(indexNew--, '%');
            }else{
                str.setCharAt(indexNew--, str.charAt(indexOld));
            }
        }
        return str.toString();
    }
}

