package main.com.lwq.demo;


import java.util.Scanner;

/**
 * @Author: Lwq
 * @Date: 2018/9/11 17:09
 * @Version 1.0
 * @Describe
 */
public class Demo15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String sourse = sc.next();
            String result = sc.next();
            System.out.println(getIndexOf(sourse,result));
        }
    }

    private static int getIndexOf(String s, String m) {
        if(s==null||m==null||m.length()<1||s.length()<1){
            return -1;
        }
        char[] ss = s.toCharArray();
        char[] ms = m.toCharArray();
        int si = 0;
        int mi = 0;
        int[] next = getNextArray(ms);
        while(si<ss.length&&mi<ms.length){
            if(ss[si]==ms[mi]){  //两个数组的第si个字母匹配上了
                si++;
                mi++;
            }else if(next[mi] == -1){  //ms的第一个字母就没有匹配上
                si++;
            }else{      //没有匹配上，而且不是ms的第一个字母，则移动mi指针到当前匹配到的字母的下标对应的next数组处
                mi = next[mi];
            }
        }
        return mi==ms.length?si-mi:-1;
    }

    private static int[] getNextArray(char[] ms) {
        if(ms.length==1){
            return new int[] {-1};
        }
        int[] next = new int[ms.length];
        next[0] = -1;
        next[1] = 0;
        int pos = 2;
        int cn = 0;
        while(pos<next.length){
            if(ms[pos-1]==ms[cn]){ //如果当前跳到的位置cn和我要求的位置pos减一处的char相等，则pos位置的next数组的值是cn+1
                next[pos++]=++cn;
            }else if(cn>0){  //如果不相等并且cn还大于0，cn就往前跳，调到以next数组的cn下标处，然后重新while判断一下
                cn = next[cn];
            }else{
                next[pos++]=0;
            }
        }
        return next;
    }
}
