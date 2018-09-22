package main.com.lwq.demo;

/**
 * @Author: Lwq
 * @Date: 2018/9/22 15:24
 * @Version 1.0
 * @Describe
 */
/*
使用Manacher算法，在一个字符串后面补齐最短的字符，让他形成一个回文串
 */
public class Manacher_ShortestEnd {

    public static char[] manacherString(String str){
        char[] charArr = str.toCharArray();
        char[] res = new char[str.length()*2+1];
        int index = 0;
        for(int i = 0; i != res.length ; i++){
            res[i] = (i&1)==0?'#':charArr[index++];
        }
        return res;
    }

    public static String maxLcpsLength(String str){
        if(str == null || str.length()==0){
            return "";
        }
        char[] charArr = manacherString(str);
        int[] pArr = new int[charArr.length];
        int index = -1;
        int pR = -1;
        int maxContainEnd = -1;
        for(int i = 0; i!=charArr.length;i++){
            pArr[i] =  pR>i?Math.min(pArr[2*index-i],pR-i):1;
            while (i+pArr[i]<charArr.length&&i-pArr[i]>-1){
                if(charArr[i+pArr[i]]==charArr[i-pArr[i]]){
                    pArr[i]++;
                }else {
                    break;
                }
            }
            if(i+pArr[i]>pR){
                pR = i+pArr[i];
                index = i;
            }
            if(pR==charArr.length){
                maxContainEnd = pArr[i];
                break;
            }
         }
         char[] res = new char[str.length()-maxContainEnd+1];
        for(int i = 0; i < res.length ; i++){
            res[res.length-i-1] = charArr[i*2+1];
        }
        return String.valueOf(res);
    }

    public static void main(String[] args) {
        String str = "abcd123321";
        System.out.println(str+maxLcpsLength(str));
    }

}
