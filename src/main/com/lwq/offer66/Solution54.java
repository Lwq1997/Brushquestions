package main.com.lwq.offer66;

/**
 * @Author: Lwq
 * @Date: 2018/10/19 11:34
 * @Version 1.0
 * @Describe
 */

import java.util.Queue;

/**
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，
 * 当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，
 * 第一个只出现一次的字符是"l"
 */
public class Solution54 {
    int[] hashtable=new int[256];
    StringBuffer s=new StringBuffer();
    //Insert one char from stringstream
    public void Insert(char ch)
    {
        s.append(ch);
        if(hashtable[ch]==0)
            hashtable[ch]=1;
        else hashtable[ch]+=1;
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        char[] str=s.toString().toCharArray();
        for(char c:str)
        {
            if(hashtable[c]==1)
                return c;
        }
        return '#';
    }
}
